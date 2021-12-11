package com.jyami

import com.jyami.plugins.*
import com.jyami.route.registerOrderRoute
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.netty.*

fun main(args: Array<String>) : Unit = EngineMain.main(args)

fun Application.module(){
    configureRouting()
    registerCustomerRoutes()
    registerOrderRoute()
    install(ContentNegotiation){
        json()
    }
}