package com.example.roadstatus.di

import com.example.data.status.StatusRepositoryImpl
import com.example.data.status.model.LineStatusModelToLineStatusMapper
import com.example.domain.status.GetRoadStatusInteractor
import com.example.domain.status.StatusRepository
import com.example.roadstatus.status.model.RoadStatusPresentationMapper
import com.example.roadstatus.status.viewmodel.StatusViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    viewModel { StatusViewModel(get(), get()) }
}

val interactorsModule = module {
    factory { GetRoadStatusInteractor(get()) }
}

val repositoryModule = module {
    single<StatusRepository> { StatusRepositoryImpl(get(), get()) }
}

val mappersModule = module {
    single { LineStatusModelToLineStatusMapper() }
    single { RoadStatusPresentationMapper() }
}