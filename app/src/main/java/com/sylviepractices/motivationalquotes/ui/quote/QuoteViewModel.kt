package com.sylviepractices.motivationalquotes.ui.quote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sylviepractices.motivationalquotes.domain.GetQuoteUseCase
import com.sylviepractices.motivationalquotes.model.QuoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuote: GetQuoteUseCase
): ViewModel() {

    private val _quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel: LiveData<QuoteModel> = _quoteModel

    fun init(){
        viewModelScope.launch {
            val result = getQuote.invoke()
            if (result.isNotEmpty()){
                _quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote(){
    }

}