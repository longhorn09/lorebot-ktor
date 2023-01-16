package com.normstorm.routes

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Route.getWhoRoute() {
    get("/who/{id}") {

    }
}
fun Route.getWhoAllRoute() {
    get("/whoall/") {

    }
}
/*
fun Route.totalizeOrderRoute() {
    get("/order/{id}/total") {

    }
}*/