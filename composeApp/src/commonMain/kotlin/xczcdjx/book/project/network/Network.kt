package xczcdjx.book.project.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Network {
    val client= HttpClient{
        // 配置默认参数
        defaultRequest {
            url("http://192.168.124.31:3010")
        }
        // 日志插件
        install(Logging){
            logger= Logger.DEFAULT
            level=LogLevel.ALL
        }
        install(ContentNegotiation){
            json(Json { // application/json
                ignoreUnknownKeys=true
                useAlternativeNames=true // 多值返回的key
            })
        }
    }
}