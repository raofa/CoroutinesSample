package com.raofa.coroutinessample.data.model.place

import com.google.gson.annotations.SerializedName

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/10/30 15:15
 * @description:
 */


data class PlaceResponse(val status : String ,val places : List<Place>)

data class Place(val name : String ,val location: Location, @SerializedName("formatted_address") val address : String)

data class Location(val lng : String ,val lat : String)