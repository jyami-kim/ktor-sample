package com.jyami

import com.jyami.plugins.configureRouting
import com.jyami.plugins.registerCustomerRoutes
import com.jyami.route.registerOrderRoute
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    configureRouting()
    registerCustomerRoutes()
    registerOrderRoute()
    install(ContentNegotiation) {
        json()
    }
}