package com.sylviepractices.motivationalquotes.ui.quote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sylviepractices.motivationalquotes.domain.GetQuoteUseCase
import com.sylviepractices.motivationalquotes.model.QuoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuote: GetQuoteUseCase
): ViewModel() {

    private val _quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel: LiveData<QuoteModel> = _quoteModel

    fun randomQuote(){
        _quoteModel.postValue(getQuote.invoke())
    }

}