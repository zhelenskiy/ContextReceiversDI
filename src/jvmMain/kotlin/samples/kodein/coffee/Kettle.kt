package samples.kodein.coffee

import samples.kodein.LoggerProvider

context(LoggerProvider)
abstract class Ration {
    abstract fun name(): String
}

interface RationProvider<T: Ration> {
    fun makeRation(): T
}

context(LoggerProvider)
class Coffee : Ration() {
    init { logger.log("<Creating CoffeeRation>") }
    override fun name(): String = "coffee"
}

context(LoggerProvider)
class Tea : Ration() {
    init { logger.log("<Creating TeaRation>") }
    override fun name(): String = "tea"
}

context (LoggerProvider, HeaterProvider, PumpProvider, RationProvider<T>)
class Kettle<T : Ration> {
    init {
        logger.log("<Creating CoffeeMaker>")
    }

    fun brew() {
        heater.on()
        pump.pumpWater()
        val ration = makeRation()

        logger.log("[_]P ${ration.name()} [_]P")
        heater.off()
    }
}
