package com.sylviepractices.motivationalquotes.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sylviepractices.motivationalquotes.model.QuoteModel

@Entity(tableName = "quotes_table")
data class QuotesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "quote")
    val quote: String,
    @ColumnInfo(name = "author")
    val author: String
)

fun QuoteModel.toEntity() = QuotesEntity(quote = quote, author = author)