package com.ariqandrean.mvvmbasic.utils

import com.ariqandrean.mvvmbasic.data.FakeDatabase
import com.ariqandrean.mvvmbasic.data.QuoteRepository
import com.ariqandrean.mvvmbasic.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository
            .getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}