package com.sylviepractices.motivationalquotes.domain.usecases

import com.sylviepractices.motivationalquotes.model.QuoteModel
import com.sylviepractices.motivationalquotes.model.QuoteProvider
import javax.inject.Inject

class GetCurrentQuoteUseCase @Inject constructor(
    private val provider: QuoteProvider
) {

    operator fun invoke(): QuoteModel? {
        val quotes = provider.quotes
        if (quotes.isNotEmpty()) {
            return quotes[(quotes.indices).random()]
        }
        return null
    }

}