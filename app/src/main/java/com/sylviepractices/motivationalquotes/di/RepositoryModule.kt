package com.sylviepractices.motivationalquotes.di

import com.sylviepractices.motivationalquotes.data.repository.QuotesRepositoryImpl
import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun providesQuotesRepository(repository: QuotesRepositoryImpl): QuotesRepository

}