package com.sylviepractices.motivationalquotes.data.api

import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    @SerializedName("quote") val quote: String?,
    @SerializedName("author") val author: String?
)