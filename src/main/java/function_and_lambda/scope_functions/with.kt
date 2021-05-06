package function_and_lambda.scope_functions

data class Config(val host: String, val port: String)

fun main() {
    val configuration = Config("kwai.com", "8080")

    with(configuration) {
        println("$host:$port")
    }

// instead of:
    println("${configuration.host}:${configuration.port}")
}