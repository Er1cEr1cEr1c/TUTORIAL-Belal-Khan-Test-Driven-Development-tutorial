package com.example.belal_khan_test_driven_development_tutorial.ui

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import net.simplifiedcoding.spendtracker.ui.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.example.belal_khan_test_driven_development_tutorial.R

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup(){
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testAddAndViewSpend(){
        onView(withId(R.id.button_add_spend)).perform(click())
        val amount = 100
        val desc = "Bought Eggs"
        onView(withId(R.id.edit_text_amount)).perform(ViewActions.typeText(amount.toString()))
        onView(withId(R.id.edit_text_description)).perform(ViewActions.typeText(desc))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button_add)).perform(click())
        onView(withText(amount.toString())).check(matches(isDisplayed()))
        onView(withText(desc)).check(matches(isDisplayed()))
    }

}