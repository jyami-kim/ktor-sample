package com.jyami

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test

import kotlin.test.assertEquals

class HoconApplicationTest {

    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}