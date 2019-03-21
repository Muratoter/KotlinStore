package com.moter.koin.repository


class HelloRepositoryImpl : HelloRepository {
    override fun hello(): String {
        return "Hello KOIN"
    }
}