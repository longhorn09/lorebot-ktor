package com.normstorm.routes

import io.ktor.server.routing.*
//import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.queryRoutes() {
    routing {
        //listCustomersRoute()
        statByIdRoute()
        briefByIdRoute()
        queryByIdRoute()
        //createCustomerRoute()
        //deleteCustomerRoute()
    }
}

fun Route.statByIdRoute() {
    var param1:String? = "";
    get("/stat/{lore}") {
        if (call.parameters["lore"] != null) {
            param1 = call.parameters["lore"]
            println("in QueryRoutes.statByIdRoute: " + param1.toString())
            call.respondText(param1.toString())
        }
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
fun Route.queryByIdRoute() {
    get("/query/{id}") {
    }
}
/*
fun Route.createCustomerRoute() {
    post("/customer") {

    }
}*/