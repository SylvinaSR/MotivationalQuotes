package com.sylviepractices.motivationalquotes.domain

import com.sylviepractices.motivationalquotes.model.QuoteModel
import com.sylviepractices.motivationalquotes.model.QuotesModelDummy
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor() {

    operator fun invoke(): QuoteModel = QuotesModelDummy.randomQuote()

}