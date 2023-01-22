package com.normstorm

import io.ktor.http.*
//import io.ktor.features.*
//import io.ktor.client.*
//import io.ktor.client.engine.cio.*
import com.zaxxer.hikari.*      //https://ktor.io/docs/connection-pooling-caching.html#enable-connection-pooling

import com.normstorm.plugins.*
import com.normstorm.routes.*

import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//import com.github.jasync.sql.db.Connection
//import com.github.jasync.sql.db.QueryResult
//import com.github.jasync.sql.db.mysql.MySQLConnectionBuilder
import kotlinx.coroutines.future.await
//import io.ktor.util.pipeline.PipelineContext
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
//import kotlin.coroutines.CoroutineContext

//https://ishroid.medium.com/ktor-database-connection-with-h2-ktor-and-exposed-100e4d3dc2e2
fun main(args: Array<String>): Unit {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}
/*
fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureQueryRouting()
    configureStatRouting()
}*/
/*
fun Application.module() {
    val config = environment.config
    //println("in application.module")
    //connectionPool.connect().get()

    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureStatRouting()

}*/

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    //val config = environment.config
    //println(config.property("mysql_ip").getString())
    println(environment.config.propertyOrNull("jwt.mysql_ip")?.getString()  ?: "mysql_ip_null" )   //?: "8080"
    //println(environment.config.propertyOrNull("jwt.mysql_ip")?.getString()  ?: "mysql_ip_null" )   //?: "8080"
    //println(environment.config.property("mysql_ip").getString());
    //println(environment.config.property("mysql_username").getString());
    //println(environment.config.property("mysql_pwd").getString());

    val hikariConfig = HikariConfig().apply {
        jdbcUrl = "jdbc:mysql://34.23.199.40:3306/Lorebot"
        username = "xxxx"
        password = "xxxx"
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    }
//OFFICIAL: https://ktor.io/docs/connection-pooling-caching.html#enable-connection-pooling
    val dataSource = HikariDataSource(hikariConfig)

    val query = "SELECT * FROM Lore Limit 10"

    val connection = dataSource.connection
    val statement = connection.createStatement()
    val result = statement.executeQuery(query)

    GlobalScope.launch {
        while (result.next()) {
            //val id = result.getInt("id")
            val name = result.getString("OBJECT_NAME")
            println("$name")
        }
    }
    connection.close()
    dataSource.close()
}