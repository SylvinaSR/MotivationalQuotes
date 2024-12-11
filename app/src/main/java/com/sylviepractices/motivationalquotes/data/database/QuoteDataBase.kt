package com.sylviepractices.motivationalquotes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sylviepractices.motivationalquotes.data.database.dao.QuotesDao
import com.sylviepractices.motivationalquotes.data.database.entities.QuotesEntity

@Database(entities = [QuotesEntity::class], version = 1)
abstract class QuoteDataBase: RoomDatabase() {

    abstract fun getQuoteDao(): QuotesDao

}