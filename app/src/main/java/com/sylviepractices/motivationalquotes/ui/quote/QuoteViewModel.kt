package com.sylviepractices.motivationalquotes.ui.quote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sylviepractices.motivationalquotes.domain.usecases.GetCurrentQuoteUseCase
import com.sylviepractices.motivationalquotes.domain.usecases.GetQuotesUseCase
import com.sylviepractices.motivationalquotes.model.QuoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuote: GetQuotesUseCase,
    private val currentQuote: GetCurrentQuoteUseCase
): ViewModel() {

    private val _quoteModel = MutableLiveData<QuoteModel?>()
    val quoteModel: LiveData<QuoteModel?> = _quoteModel

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        init()
    }

    fun init(){
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = getQuote.invoke()
            if (result.isNotEmpty()){
                _isLoading.postValue(false)
                _quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote(){
        _isLoading.postValue(true)
        val quote = currentQuote.invoke()
        if (quote != null){
            _quoteModel.postValue(quote)
        }
        _isLoading.postValue(false)
    }

}