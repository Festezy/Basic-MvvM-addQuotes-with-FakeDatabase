package com.ariqandrean.mvvmbasic.data.viewmodel

import androidx.lifecycle.ViewModel
import com.ariqandrean.mvvmbasic.data.QuoteRepository
import com.ariqandrean.mvvmbasic.data.model.QuoteModel

class QuotesViewModel(private val quotesRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quotesRepository.getQuotes()

    fun addQuote(quote: QuoteModel) = quotesRepository.addQuote(quote)
}