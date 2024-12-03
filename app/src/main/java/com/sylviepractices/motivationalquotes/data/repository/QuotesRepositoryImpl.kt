package com.sylviepractices.motivationalquotes.data.repository

import com.sylviepractices.motivationalquotes.data.api.ApiService
import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import com.sylviepractices.motivationalquotes.model.QuoteModel
import com.sylviepractices.motivationalquotes.model.QuoteProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): QuotesRepository {

    override suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = apiService.getAllQuotes()
            QuoteProvider.quotes = response.body() ?: emptyList()
            response.body() ?: emptyList()
        }
    }

}