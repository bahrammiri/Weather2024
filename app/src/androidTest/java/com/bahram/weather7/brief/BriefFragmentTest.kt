package com.bahram.weather7.brief

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bahram.weather7.R
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MyTestSuite {

    //    private lateinit var scenario: FragmentScenario<BriefFragment>
//
//    @Before
//    fun setup() {
//      scenario  = launchFragmentInContainer(themeResId = R.style.Theme_Weather7)
//    }
    @Test
    fun test_visibility_BriefFragment() {
        launchFragmentInContainer<BriefFragment>()
        onView(withId(R.id.edit_text_city_name)).check(matches(isDisplayed()))
    }

    @Test
    fun editTextCityName() {
        val city = "Qom"
        launchFragmentInContainer<BriefFragment>()
        onView(withId(R.id.edit_text_city_name)).perform(typeText(city)).check(matches(withText("Qom")))

    }

    @Test
    fun recyclerViewBrief() {
        launchFragmentInContainer<BriefFragment>()
        onView(withId(R.id.recycler_view_brief)).check(matches(isDisplayed()))
    }

}