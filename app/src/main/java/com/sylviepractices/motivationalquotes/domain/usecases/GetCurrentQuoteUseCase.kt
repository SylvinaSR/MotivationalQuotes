package com.sylviepractices.motivationalquotes.domain.usecases

import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import com.sylviepractices.motivationalquotes.model.QuoteModel
import javax.inject.Inject

class GetCurrentQuoteUseCase @Inject constructor(
    private val repository: QuotesRepository
) {

    suspend operator fun invoke(): QuoteModel? {
        val quotes = repository.getQuotesFromDatabase()
        if (quotes.isNotEmpty()) {
            return quotes[(quotes.indices).random()]
        }
        return null
    }

}