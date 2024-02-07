package com.example.belal_khan_test_driven_development_tutorial

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage

@RunWith(JUnit4::class)
class ValidatorTest {
    @Test
    fun whenInputIsValid() {
        val amount = 100
        val description = "Random description"
        val result = Validator.validateInput(amount, description)

        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInputIsInvalid() {
        val amount = 0
        val description = ""
        val result = Validator.validateInput(amount, description)

        assertThat(result).isEqualTo(false)
    }
}