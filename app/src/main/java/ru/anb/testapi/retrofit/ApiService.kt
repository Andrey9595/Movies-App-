package ru.anb.testapi.retrofit

import retrofit2.Call
import retrofit2.http.GET
import ru.anb.testapi.models.Categories

interface ApiService {

    @GET("/api/ppp/index/")
//    suspend fun getItems(@Query("page") page: Int, @Query("search") search: String): Response<List<Categories>>
    fun getCountryList(): Call<List<Categories>>
}