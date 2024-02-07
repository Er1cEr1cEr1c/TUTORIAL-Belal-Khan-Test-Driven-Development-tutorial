package com.example.belal_khan_test_driven_development_tutorial

object Validator {
    fun validateInput(amount: Int, description: String): Boolean {
        return !(amount <= 0 || description.isEmpty())
    }
}