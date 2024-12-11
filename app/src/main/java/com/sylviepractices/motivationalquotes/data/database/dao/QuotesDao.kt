package com.sylviepractices.motivationalquotes.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sylviepractices.motivationalquotes.data.database.entities.QuotesEntity

@Dao
interface QuotesDao {

    @Query("SELECT * FROM quotes_table ORDER BY author DESC")
    fun getAllQuotes(): List<QuotesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuotesEntity>)

    @Query("DELETE FROM quotes_table")
    suspend fun deleteQuotes()

}