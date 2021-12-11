package com.jyami.models

import kotlinx.serialization.Serializable


val customerStorage = mutableListOf<Customer>()

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)
