package com.moter.koin

import com.moter.koin.presenter.MySimplePresenter
import com.moter.koin.repository.HelloRepository
import com.moter.koin.repository.HelloRepositoryImpl
import org.koin.dsl.module


var helloModule = module {
    single { HelloRepositoryImpl() as HelloRepository }
    factory { MySimplePresenter(get()) }
}
