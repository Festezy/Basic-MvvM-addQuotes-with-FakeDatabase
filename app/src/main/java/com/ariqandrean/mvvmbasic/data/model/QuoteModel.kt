package com.ariqandrean.mvvmbasic.data.model

data class QuoteModel(val quoteText: String, val author: String){
    /** Member Function*/
    override fun toString(): String {
        return "$quoteText - $author"
    }
}
