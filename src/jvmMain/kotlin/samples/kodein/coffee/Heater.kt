package samples.kodein.coffee

interface Heater {
    fun on()
    fun off()
    val isHot: Boolean
}

interface HeaterProvider {
    val heater: Heater
}
