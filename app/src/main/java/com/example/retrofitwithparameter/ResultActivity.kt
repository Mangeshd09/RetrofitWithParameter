package com.example.retrofitwithparameter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.retrofitwithparameter.databinding.ActivityResultBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val result = intent.getSerializableExtra("VALUE") as ResponseData

        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)

        binding.userFirstNameText.text = "First Name: " + result.result.userFirstName +
                "Auth Token :" + result.result.authToken + "User Id: " + result.result.userId +
                "User Language :" + result.result.userLang

    }
}