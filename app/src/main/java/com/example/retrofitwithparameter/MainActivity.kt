package com.example.retrofitwithparameter

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.retrofitwithparameter.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val MY_URL = "https://kintree.com/preprod/services/user/"

class MainActivity : AppCompatActivity() {
    private lateinit var username1: String
    private lateinit var password: String
    private lateinit var error: String
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        username1 = binding.userNameEditText.text.toString()
        password = binding.passwordEditText.text.toString()

        binding.loginButton.setOnClickListener {

            if (binding.userNameEditText.text.isEmpty() && binding.passwordEditText.text.isEmpty()) {
                binding.errorTextView.visibility = View.VISIBLE
                binding.errorTextView.text = "Please Enter Username and Password"
            } else {
                binding.errorTextView.visibility = View.GONE
                getMyData()
            }
        }


    }

    private fun getMyData() {
        val client = OkHttpClient.Builder().build()
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MY_URL)
            .client(client)
            .build()
            .create(MyAPI::class.java)

        val myData = MyData(
            binding.userNameEditText.text.toString(),
            binding.passwordEditText.text.toString(),
            "Android",
            "1.1.1",
            "en"
        )


        val retrofitData = retrofitBuilder.getData(myData)


        retrofitData.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                if (response.body() != null) {

                    if (response.body()!!.status == 200) {
                        lifecycleScope.launch {
                            val data =  response.body()!!
                            val intent = Intent(applicationContext, ResultActivity::class.java)
                            intent.putExtra("VALUE", data)
                            startActivity(intent)

                            Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                        }



                    }

//                    Log.d("Result", response.body()!!.result.userId)

                } else {
                    binding.errorTextView.text = "You entered wrong username and password"
                }

            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_LONG).show()
            }
        })
    }
}