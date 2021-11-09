package com.ariqandrean.mvvmbasic.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ariqandrean.mvvmbasic.data.model.QuoteModel

class FakeQuoteDao {
    private val quoteList = mutableListOf<QuoteModel>()
    private val quotes = MutableLiveData<List<QuoteModel>>()

    init {
        /** Initialize value of variable quotes ^^ */
        quotes.value = quoteList
    }

    fun addQuote(quote: QuoteModel){
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<QuoteModel>>
}