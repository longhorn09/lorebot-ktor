package com.normstorm.routes

import io.ktor.server.routing.*
//import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureQueryRouting() {
    routing {
        queryByIdRoute()
    }
}
fun Route.queryByIdRoute() {
    var param1:String? = "";
    get("/query/{lore}") {
        if (call.parameters["lore"] != null) {
            param1 = call.parameters["lore"]
            println("in QueryRoutes.queryByIdRoute: " + param1.toString())
            call.respondText(param1.toString())
        }
    }
}