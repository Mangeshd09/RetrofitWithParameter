package com.example.retrofitwithparameter

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
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

        //"https://kintree.com/preprod/${result.result.userImage}"
        Glide.with(applicationContext)
            .load("https://kintree.com/preprod/${result.result.userImage}")
            .error(R.drawable.ic_baseline_image_24)
            .into(binding.imageView)

        binding.userFirstNameText.text = "First Name: " + result.result.userFirstName +
                "Auth Token :" + result.result.authToken + "User Id: " + result.result.userId +
                "User Language :" + result.result.userLang + "IMAGE URL :" + result.result.userImage

    }
}