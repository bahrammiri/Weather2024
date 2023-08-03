package com.bahram.weather7.brief

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bahram.weather7.util.SharedPreferencesManager
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class BriefViewModelTest : TestCase() {
    private lateinit var viewModel: BriefViewModel


    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        var sh = SharedPreferencesManager(context)

        viewModel = BriefViewModel(sh)

    }

    @Test
    fun name() {
        TODO("Not yet implemented")
    }


    @Test
    fun testBriefViewModel() {

    }


}