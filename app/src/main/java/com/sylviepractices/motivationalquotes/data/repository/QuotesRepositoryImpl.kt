package com.sylviepractices.motivationalquotes.data.repository

import com.sylviepractices.motivationalquotes.data.api.ApiService
import com.sylviepractices.motivationalquotes.data.database.dao.QuotesDao
import com.sylviepractices.motivationalquotes.data.database.entities.QuotesEntity
import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import com.sylviepractices.motivationalquotes.model.QuoteModel
import com.sylviepractices.motivationalquotes.model.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val quoteDao: QuotesDao
): QuotesRepository {

    override suspend fun getQuotesFromService(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = apiService.getAllQuotes()
            response.body()?.map { it.toModel() } ?: emptyList()
        }
    }

    override suspend fun getQuotesFromDatabase(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = quoteDao.getAllQuotes()
            response.map { it.toModel() }
        }
    }

    override suspend fun insertQuotes(quotes: List<QuotesEntity>) {
        quoteDao.insertAll(quotes)
    }

    override suspend fun clearQuotes() {
        quoteDao.deleteQuotes()
    }


}