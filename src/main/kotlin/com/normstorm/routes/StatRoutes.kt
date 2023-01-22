package com.normstorm.routes

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.serialization.Serializable
//import io.ktor.http.*
//import io.ktor.features.*
//import io.ktor.client.*
//import io.ktor.client.engine.cio.*
//import kotlinx.coroutines.*
//import com.zaxxer.hikari.*
//import kotlin.coroutines.CoroutineContext

fun Application.configureStatRouting() {
    routing {
        statByIdRoute()
        //briefByIdRoute()
    }
}

/**
 * need Serializable and data class to return as JSON
 */
@Serializable
data class ReturnMsg(val name: String, var lore: String)
fun Route.statByIdRoute() {
    var param1:String? = "";
    get("/stat/{lore}") {
        if (call.parameters["lore"] != null) {
            param1 = call.parameters["lore"]
            println("in StatRoutes.statByIdRoute: " + param1.toString())
            //call.respondText(param1.toString())
            call.respond(ReturnMsg("ok",param1.toString()))
        }
    }
}