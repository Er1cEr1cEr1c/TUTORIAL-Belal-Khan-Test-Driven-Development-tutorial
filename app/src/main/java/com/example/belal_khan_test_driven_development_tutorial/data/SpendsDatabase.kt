package com.example.belal_khan_test_driven_development_tutorial.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.belal_khan_test_driven_development_tutorial.util.DateConverter

@Database(entities = [SpendEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class SpendsDatabase : RoomDatabase() {

    abstract fun getSpendDao(): SpendDao

    companion object {
        private const val DB_NAME = "Spends-Database.db"

        @Volatile
        private var instance: SpendsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SpendsDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }
}