package com.example.belal_khan_test_driven_development_tutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.belal_khan_test_driven_development_tutorial.data.SpendEntity
import com.example.belal_khan_test_driven_development_tutorial.data.SpendsTrackerDataSource
import kotlinx.coroutines.launch

import java.util.*

class SpendViewModel(
    private val dataSource: SpendsTrackerDataSource
) : ViewModel() {

    private val _last20SpendsLiveData = MutableLiveData<List<SpendEntity>>()
    val last20SpendsLiveData: LiveData<List<SpendEntity>>
        get() = _last20SpendsLiveData

    fun addSpend(amount: Int, description: String) = viewModelScope.launch {
        dataSource.addSpend(SpendEntity(Date(), amount, description))
    }

    fun getLast20Spends() = viewModelScope.launch {
        _last20SpendsLiveData.value = dataSource.getLast20Spends()
    }
}