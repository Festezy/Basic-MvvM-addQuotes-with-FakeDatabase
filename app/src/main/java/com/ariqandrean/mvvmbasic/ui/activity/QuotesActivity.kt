package com.ariqandrean.mvvmbasic.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ariqandrean.mvvmbasic.data.model.QuoteModel
import com.ariqandrean.mvvmbasic.data.viewmodel.QuotesViewModel
import com.ariqandrean.mvvmbasic.databinding.ActivityQuotesBinding
import com.ariqandrean.mvvmbasic.utils.InjectorUtils
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this@QuotesActivity, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this@QuotesActivity, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote -> stringBuilder.append("$quote\n\n") }

            binding.tvQuote.text = stringBuilder.toString()
        })
        binding.btnAddQuote.setOnClickListener {
            val quote = QuoteModel(binding.etQuote.text.toString(),
                binding.etAuthor.text.toString() )
            viewModel.addQuote(quote)
            binding.etQuote.setText("")
            binding.etAuthor.setText("")
            Toast.makeText(this@QuotesActivity, "Success", Toast.LENGTH_SHORT).show()
        }
    }
}