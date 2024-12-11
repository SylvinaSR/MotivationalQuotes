package com.sylviepractices.motivationalquotes.domain.repository

import com.sylviepractices.motivationalquotes.data.database.entities.QuotesEntity
import com.sylviepractices.motivationalquotes.model.QuoteModel

interface QuotesRepository {

    suspend fun getQuotesFromService(): List<QuoteModel>

    suspend fun getQuotesFromDatabase(): List<QuoteModel>

    suspend fun insertQuotes(quotes: List<QuotesEntity>)

    suspend fun clearQuotes()

}