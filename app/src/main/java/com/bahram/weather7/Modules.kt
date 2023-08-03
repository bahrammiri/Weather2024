package com.bahram.weather7

import com.bahram.weather7.brief.BriefViewModel
import com.bahram.weather7.detail.DetailViewModel
import com.bahram.weather7.util.SharedPreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        SharedPreferencesManager(androidContext())
    }


}


val viewModelModule = module {
    viewModel { BriefViewModel(get()) }
//    viewModel { PreviewViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}




