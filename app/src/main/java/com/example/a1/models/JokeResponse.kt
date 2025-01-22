package com.example.a1.models

data class JokeResponse(
    val type: String,
    val setup: String?,
    val delivery: String?
) {
    val joke: String
        get() = if (type == "twopart" && setup != null && delivery != null) {
            "$setup $delivery"
        } else {
            setup ?: delivery ?: "No joke found"
        }
}
