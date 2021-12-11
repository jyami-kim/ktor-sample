package com.jyami.route

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals


internal class OrderRoutingKtTest {

    fun Application.testModule(){
        registerOrderRoute()
        install(ContentNegotiation){
            json()
        }
    }

    @Test
    fun testGetOrder() {
        withTestApplication({ testModule() }) {
            handleRequest(HttpMethod.Get, "/order/2020-04-06-01").apply {
                assertEquals(
                    """{"number":"2020-04-06-01","contents":[{"item":"Ham Sandwich","amount":2,"price":5.5},{"item":"Water","amount":1,"price":1.5},{"item":"Beer","amount":3,"price":2.3},{"item":"Cheesecake","amount":1,"price":3.75}]}""",
                    response.content
                )
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }

    }

}