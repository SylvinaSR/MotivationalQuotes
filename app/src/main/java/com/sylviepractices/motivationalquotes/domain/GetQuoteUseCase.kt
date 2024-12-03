package com.sylviepractices.motivationalquotes.domain

import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import com.sylviepractices.motivationalquotes.model.QuoteModel
import com.sylviepractices.motivationalquotes.model.QuotesModelDummy
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuotesRepository
) {

    suspend operator fun invoke(): List<QuoteModel> = repository.getQuotes()

}