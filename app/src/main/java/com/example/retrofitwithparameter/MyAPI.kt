package com.example.retrofitwithparameter

import com.google.gson.annotations.Expose
import retrofit2.Call
import retrofit2.http.*

interface MyAPI {
    @Headers("Auth-key:familyrestapi")
    @POST("loginUser")
    fun getData(@Body myData: MyData): Call<ResponseData>

}