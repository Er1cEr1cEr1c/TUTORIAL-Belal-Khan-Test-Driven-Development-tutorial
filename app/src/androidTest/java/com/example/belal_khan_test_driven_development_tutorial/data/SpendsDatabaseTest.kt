package com.example.belal_khan_test_driven_development_tutorial.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage

@RunWith(AndroidJUnit4::class)
class SpendsDatabaseTest: TestCase() {
    private lateinit var db: SpendsDatabase
    private lateinit var dao: SpendDao

    @Before //will be called before each test function; ensure that function is public
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>() //brought to you by the truth library
        db = Room.inMemoryDatabaseBuilder(context, SpendsDatabase::class.java).build() //super testing specific database creator
        db.getSpendDao()
        dao = db.getSpendDao()
    }

    @After
    public fun closeDb() {
        db.close()
    }

    @Test
    public fun writeAndReadSpend() = runBlocking {
        val date = Date()
        val spend = SpendEntity(date, 100, "bought something")

        dao.addSpend(spend)
        val spendsList = dao.getLast20Spends()

        assertThat(spendsList.contains(spend)).isTrue()
    }
}