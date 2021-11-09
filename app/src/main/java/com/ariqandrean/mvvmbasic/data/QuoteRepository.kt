package com.ariqandrean.mvvmbasic.data

import com.ariqandrean.mvvmbasic.data.model.QuoteModel

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: QuoteModel){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this){
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}