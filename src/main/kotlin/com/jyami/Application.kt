package com.jyami

import com.jyami.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 9090, host = "0.0.0.0") {
        configureRouting()
        registerCustomerRoutes()
        install(ContentNegotiation){
            json()
        }
    }.start(wait = true)
}