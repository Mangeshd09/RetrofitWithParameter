package com.example.retrofitwithparameter

import java.io.Serializable

data class MyData(
    val username : String,
    val password : String,
    val deviceType : String,
    val appVersion : String,
    val userlang : String
):Serializable
