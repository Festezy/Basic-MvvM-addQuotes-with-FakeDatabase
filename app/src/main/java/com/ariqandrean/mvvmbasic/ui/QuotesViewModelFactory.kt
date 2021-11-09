package com.ariqandrean.mvvmbasic.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ariqandrean.mvvmbasic.data.QuoteRepository
import com.ariqandrean.mvvmbasic.data.viewmodel.QuotesViewModel

class QuotesViewModelFactory(private val quotesRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory(){

    // UNCHECKED_CAST
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }
}