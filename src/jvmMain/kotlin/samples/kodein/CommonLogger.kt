package samples.kodein

interface CommonLogger {
    fun log(msg: String)
}

interface LoggerProvider {
    val logger: CommonLogger
}