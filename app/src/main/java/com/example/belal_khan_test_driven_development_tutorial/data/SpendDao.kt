package com.example.belal_khan_test_driven_development_tutorial.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SpendDao {

    @Insert
    suspend fun addSpend(spend: SpendEntity)

    @Query("SELECT * FROM SpendEntity ORDER BY date DESC LIMIT 20")
    suspend fun getLast20Spends(): List<SpendEntity>

}
