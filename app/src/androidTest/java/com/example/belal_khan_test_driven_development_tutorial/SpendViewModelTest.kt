package com.example.belal_khan_test_driven_development_tutorial

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.belal_khan_test_driven_development_tutorial.data.SpendsDatabase
import com.example.belal_khan_test_driven_development_tutorial.data.SpendsTrackerDataSource
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

class SpendViewModelTest: TestCase() {

    private lateinit var viewModel:SpendViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room
            .inMemoryDatabaseBuilder(context, SpendsDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        val dataSource = SpendsTrackerDataSource(db.getSpendDao())

        viewModel = SpendViewModel(dataSource)
    }

    @Test
    fun testSpendViewModel(){
        viewModel.addSpend(170, "Bought some flowers")
        viewModel.getLast20Spends()
        val result = viewModel.last20SpendsLiveData.getOrAwaitValue().find {
            it.amount == 170 && it.description == "Bought some flowers"
        }
        assertThat(result != null).isTrue()
    }

}