package com.example.retrofitwithparameter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.retrofitwithparameter.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val result = intent.getStringExtra("value")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        binding.userFirstNameText.text = result

    }
}