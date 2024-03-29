package net.simplifiedcoding.spendtracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.belal_khan_test_driven_development_tutorial.data.SpendsTrackerDataSource

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val dataSource: SpendsTrackerDataSource
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SpendViewModel(dataSource) as T
    }
}