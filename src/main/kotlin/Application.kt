package com.example

import io.ktor.server.application.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    // JSON 직렬화 플러그인 설치
    install(io.ktor.server.plugins.contentnegotiation.ContentNegotiation) {
        json()
    }

    configureRouting()
}
