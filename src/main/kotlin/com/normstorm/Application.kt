package com.normstorm

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.normstorm.plugins.*
import com.normstorm.routes.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureRouting()
    queryRoutes()
}
