package com.bahram.weather7.preview

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bahram.weather7.R
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PreviewFragmentTest {
//    @Before
//    fun setUp() {
//        launchFragmentInContainer<PreviewFragment>(
//            themeResId = R.style.Theme_Weather7
//        )
//    }


//    @Test
//    fun test_visibility_PreviewFragment() {
//        launchFragmentInContainer<PreviewFragment>()
//        onView(withId(R.id.text_view_add)).check(matches(isDisplayed()))
//
//    }
//
//    @Test
//    fun testTextViewAdd() {
//        val add = "Add"
//        launchFragmentInContainer<PreviewFragment>()
//
//        onView(withId((R.id.text_view_add))).check(matches(withText(add)))
//
//    }

    @Test
    fun testTextViewCancel() {
        launchFragmentInContainer<PreviewFragment>()
        onView(withId(R.id.text_view_cancel)).check(matches(isDisplayed()))
    }


}