package com.normstorm.routes

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Route.getWhoRoute() {
    get("/who/{id}") {
        call.respondText("in WhoRoutes.routes.getWhoAllRoute()")
    }
}
fun Route.getWhoAllRoute() {
    get("/whoall/") {
        call.respondText("in WhoRoutes.routes.getWhoAllRoute()")
    }
}