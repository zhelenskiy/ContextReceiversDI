package samples.kodein.coffee

import samples.kodein.LoggerProvider

context (LoggerProvider, HeaterProvider)
class Thermosiphon : Pump {

    init {
        logger.log("<Creating Thermosiphon>")
    }

    override fun pumpWater() {
        if (heater.isHot)
            logger.log("=> => pumping => =>")
        else
            logger.log("!!! water is cold !!!")
    }
}

context (LoggerProvider, HeaterProvider)
val thermosiphonModule: PumpProvider
    get() = object : PumpProvider {
        override val pump: Pump by lazy { Thermosiphon() }
    }