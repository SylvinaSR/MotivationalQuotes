package com.sylviepractices.motivationalquotes.di

import android.content.Context
import androidx.room.Room
import com.sylviepractices.motivationalquotes.data.database.QuoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DATABASE_NAME = "quotes_database"

    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDataBase::class.java, QUOTE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providesQuoteDao(db: QuoteDataBase) = db.getQuoteDao()

}