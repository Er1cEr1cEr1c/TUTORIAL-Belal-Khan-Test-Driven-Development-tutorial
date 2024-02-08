package com.example.belal_khan_test_driven_development_tutorial.data

class SpendsTrackerDataSource(
    private val db: SpendDao
) {
    suspend fun addSpend(spend: SpendEntity) = db.addSpend(spend)

    suspend fun getLast20Spends() = db.getLast20Spends()
}