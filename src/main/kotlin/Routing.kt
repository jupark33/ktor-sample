package com.example

import io.ktor.server.application.* 
import io.ktor.server.routing.* 
import io.ktor.server.response.* 
import io.ktor.server.request.* 
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        // 새로운 /api/v1/echo 라우트 
        post("/api/v1/echo") { 
            val request = call.receive<EchoRequest>() // 타입 명시
            call.respond(EchoResponse("Echo: ${request.message}"))
        }
    }
}

@Serializable data class EchoRequest(val message: String) 
@Serializable data class EchoResponse(val result: String)
