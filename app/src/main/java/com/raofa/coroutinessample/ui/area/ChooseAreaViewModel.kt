package com.raofa.coroutinessample.ui.area

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raofa.coroutinessample.SampleApp
import com.raofa.coroutinessample.data.PlaceRepository
import com.raofa.coroutinessample.data.model.place.Place
import kotlinx.coroutines.launch
import java.util.ArrayList

class ChooseAreaViewModel(private val placeRepository: PlaceRepository) : ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    var dataChanged = MutableLiveData<Int>()
    
    val placeList = ArrayList<Place>()

    
    fun searchPlace(query : String){
        launch { 
            val response = placeRepository.searchPlace(query)
            placeList.addAll(response.places)
            
        }
    }

    private fun launch(block: suspend () -> Unit) = viewModelScope.launch {
        try {
            isLoading.value = true
            placeList.clear()
            block()
            dataChanged.value = dataChanged.value?.plus(1)
            isLoading.value = false
        } catch (t: Throwable) {
            t.printStackTrace()
            Toast.makeText(SampleApp.mContext, t.message, Toast.LENGTH_SHORT).show()
            dataChanged.value = dataChanged.value?.plus(1)
            isLoading.value = false
        }
    }
}
