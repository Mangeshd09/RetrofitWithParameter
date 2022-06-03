package com.example.retrofitwithparameter

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseData(
        val status: Int,
        val message: String,
        val result: FieldData
):Serializable

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
):Serializable
