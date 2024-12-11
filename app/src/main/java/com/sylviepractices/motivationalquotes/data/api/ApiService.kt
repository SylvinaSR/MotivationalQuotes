package com.sylviepractices.motivationalquotes.data.api

import com.sylviepractices.motivationalquotes.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteResponse>>

}