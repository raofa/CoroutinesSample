package com.raofa.coroutinessample.data.net.api

import com.raofa.coroutinessample.SampleApp
import com.raofa.coroutinessample.data.model.place.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/10/30 15:13
 * @description:
 */
interface PlaceApi {

    @GET("v2/place?token=${SampleApp.TOKEN}&lang=zh_CN")
    fun searchPlace(@Query("query") place : String) : Call<PlaceResponse>

}