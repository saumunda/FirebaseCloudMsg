package com.saurabhbhola.centurion

import Persons
import android.app.Person
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("volley_array.json")
    fun getPerson() : Call<List<Persons>>

    companion object {

        var BASE_URL = "https://cart2day.com/sms/api/getAllStudents/"
    //    var BASE_URL = "https://randomuser.me/api/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }


}