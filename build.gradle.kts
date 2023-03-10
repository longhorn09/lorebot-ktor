val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val hikaricp_version: String by project
val ehcache_version: String by project
plugins {
    kotlin("jvm") version "1.8.0"
    id("io.ktor.plugin") version "2.2.2"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

group = "com.normstorm"
version = "0.0.1"
application {
    mainClass.set("com.normstorm.ApplicationKt")
   // mainClass.set("io.ktor.server.netty.EngineMain")
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    jcenter()     // this seemed to resolve the hikariCP
}
//https://stackoverflow.com/questions/69079963/how-to-set-compilejava-task-11-and-compilekotlin-task-1-8-jvm-target-com
java {
    //sourceCompatibility = JavaVersion.VERSION_11
    //targetCompatibility = JavaVersion.VERSION_11
    toolchain.languageVersion.set(JavaLanguageVersion.of(18))
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // MySQL
    //implementation("com.github.jasync-sql:jasync-mysql:0.9.23")
    implementation("com.zaxxer:HikariCP:$hikaricp_version")
    implementation("mysql:mysql-connector-java:8.0.31")
    implementation("org.ehcache:ehcache:$ehcache_version")


    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
/*
sourceSets["main"].apply {
    resources.srcDir("src/main/resources")
}*/