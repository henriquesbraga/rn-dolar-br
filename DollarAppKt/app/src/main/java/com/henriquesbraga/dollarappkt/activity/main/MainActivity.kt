package com.henriquesbraga.dollarappkt.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.henriquesbraga.dollarappkt.databinding.ActivityMainBinding
import com.henriquesbraga.dollarappkt.model.ApiResponse
import com.henriquesbraga.dollarappkt.model.USD
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter = MainPresenter(this)
        presenter.getData()

    }

    override fun showLoading() {
        binding.progressbar.isVisible = true
    }

    override fun hideLoading() {
        binding.progressbar.isVisible = false
    }

    override fun onGetResult(apiResponse: ApiResponse) {

        val value = apiResponse.usd.low.toDouble()

        binding.dlrvalue.text = String.format("%.2f", value)
        Toast.makeText(this, apiResponse.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onErrorLoading(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}