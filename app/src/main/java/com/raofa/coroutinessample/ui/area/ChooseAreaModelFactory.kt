package com.raofa.coroutinessample.ui.area

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raofa.coroutinessample.data.PlaceRepository

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/10/30 16:15
 * @description:
 */
class ChooseAreaModelFactory(private val placeRepository: PlaceRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChooseAreaViewModel(placeRepository) as T
    }
}