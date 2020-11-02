package com.raofa.coroutinessample.data

import com.raofa.coroutinessample.data.net.NetWorkManger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/10/30 15:22
 * @description:
 */
class PlaceRepository private constructor(private val netWorkManger: NetWorkManger){
    
    suspend fun searchPlace(place : String) = withContext(Dispatchers.IO){
        val placeResponse = netWorkManger.searchPlace(place)
        placeResponse
    }
    

    companion object {

        private var instance: PlaceRepository? = null

        fun getInstance( network: NetWorkManger): PlaceRepository {
            if (instance == null) {
                synchronized(PlaceRepository::class.java) {
                    if (instance == null) {
                        instance = PlaceRepository(network)
                    }
                }
            }
            return instance!!
        }

    }

}