package com.example.belal_khan_test_driven_development_tutorial.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.Date

@Entity
data class SpendEntity(
    val date: Date,
    val amount: Int,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
