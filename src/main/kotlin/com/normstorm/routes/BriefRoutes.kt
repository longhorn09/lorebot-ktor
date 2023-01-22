package com.normstorm.routes

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.serialization.Serializable


fun Application.configureBriefRouting() {
    routing {
        briefByIdRoute()
    }
}

fun Route.briefByIdRoute() {
    var param1:String? = "";
    get("/brief/{id}") {
        if (call.parameters["lore"] != null) {
            param1 = call.parameters["lore"]
            println("in QueryRoutes.statByIdRoute: " + param1.toString())
            call.respondText(param1.toString())
        }
    }
}