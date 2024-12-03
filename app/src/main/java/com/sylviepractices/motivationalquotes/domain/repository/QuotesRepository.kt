package com.sylviepractices.motivationalquotes.domain.repository

import com.sylviepractices.motivationalquotes.model.QuoteModel

interface QuotesRepository {

    suspend fun getQuotes(): List<QuoteModel>

}