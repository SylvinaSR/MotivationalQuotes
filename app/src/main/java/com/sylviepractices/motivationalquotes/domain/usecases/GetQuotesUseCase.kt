package com.sylviepractices.motivationalquotes.domain.usecases

import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import com.sylviepractices.motivationalquotes.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuotesRepository
) {

    suspend operator fun invoke(): List<QuoteModel> = repository.getQuotes()

}