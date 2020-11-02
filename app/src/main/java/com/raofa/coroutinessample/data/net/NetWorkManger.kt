package com.raofa.coroutinessample.data.net

import com.raofa.coroutinessample.data.net.api.PlaceApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/10/30 15:05
 * @description:
 */
class NetWorkManger {
    private val BASE_URL = "https://api.caiyunapp.com/"

    private val httpClient = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()
    
    private val placeApi = retrofit.create<PlaceApi>()
    
    
    suspend fun searchPlace(place : String) = placeApi.searchPlace(place).await()
    
    
    companion object {
        private var instance : NetWorkManger? = null
        
        fun getInstance() : NetWorkManger {
            if(instance == null){
                synchronized(NetWorkManger::class.java){
                    if(instance == null){
                        instance = NetWorkManger()
                    }
                }
            }
            return instance!!
        }
        
        
    }
}