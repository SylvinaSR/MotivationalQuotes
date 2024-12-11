package com.sylviepractices.motivationalquotes.model

import com.sylviepractices.motivationalquotes.data.api.QuoteResponse
import com.sylviepractices.motivationalquotes.data.database.entities.QuotesEntity

data class QuoteModel(
    val quote: String,
    val author: String
)

fun QuoteResponse.toModel() = QuoteModel(quote = quote ?: "", author = author ?: "")
fun QuotesEntity.toModel() = QuoteModel(quote = quote ?: "", author = author ?: "")
