package com.plcoding.navigationdrawercompose.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Details(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

const val Base_URL = "https://jsonplaceholder.typicode.com/"

interface APIService {
    @GET("todos")
    suspend fun getDetails():List<Details>

    companion object{
        var apiService:APIService? = null
        fun getInstance():APIService{
            if(apiService == null){
                apiService = Retrofit.Builder().
                        baseUrl(Base_URL).
                addConverterFactory(GsonConverterFactory.create()).build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}