package samples.kodein.coffee

import samples.kodein.LoggerProvider


context(LoggerProvider)
class ElectricHeater : Heater {
    private var heating: Boolean = false

    init {
        logger.log("<Creating ElectricHeater>")
    }

    override fun on() {
        logger.log("~ ~ ~ heating ~ ~ ~")
        this.heating = true
    }

    override fun off() {
        logger.log(". . . cooling . . .")
        this.heating = false
    }

    override val isHot: Boolean get() = heating
}

context (LoggerProvider)
val electricHeaterModule: HeaterProvider
    get() = object : HeaterProvider {
        override val heater: Heater by lazy { ElectricHeater() }
    }
