package samples.kodein

fun main() {
    with(ConsoleDemoRunner()) {
        KodeinMppApplication()
    }
}

class ConsoleDemoRunner: AbstractDemoRunner() {
    override val logger: CommonLogger = ConsoleLogger()
}

private class ConsoleLogger: CommonLogger {
    override fun log(msg: String) {
        println(msg)
    }
}