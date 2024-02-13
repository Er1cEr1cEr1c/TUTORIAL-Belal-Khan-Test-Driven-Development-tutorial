package com.example.belal_khan_test_driven_development_tutorial.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import net.simplifiedcoding.spendtracker.ui.AddSpendFragment
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import com.example.belal_khan_test_driven_development_tutorial.R
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class AddSpendFragmentTest {
    private lateinit var scenario: FragmentScenario<AddSpendFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_SpendTracker)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testAddingSpend() {
        val amount = 100
        val desc = "Bought Eggs"
        //Espresso Matcher and Action
        onView(withId(R.id.edit_text_amount)).perform(typeText(amount.toString()))
        onView(withId(R.id.edit_text_description)).perform(typeText(desc))
        Espresso.closeSoftKeyboard()    //Even getting the keyboard out of the way from the user's view is taken into account
        onView(withId(R.id.button_add)).perform(click())

        //Assertion
//        onView(withId(R.id.text_view_success_message)).check(matches(withText("Spend successfully added")))
        onView(withId(R.id.text_view_success_message)).check(matches(withText("Spend successfully added")))
    }
}