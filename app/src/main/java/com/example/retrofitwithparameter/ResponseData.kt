package com.example.retrofitwithparameter

import com.google.gson.annotations.SerializedName

data class ResponseData(
        val status: String,
        val message: String,
        val result: FieldData
)

data class FieldData(
        @SerializedName("userId")
        val userId: String,
        @SerializedName("Auth-Token")
        val authToken: String,
        @SerializedName("user_firstname")
        val userFirstName: String,
        @SerializedName("password_status")
        val passwordStatus: String,
        @SerializedName("user_image")
        val userImage: String,
        @SerializedName("user_lang")
        val userLang: String
)
