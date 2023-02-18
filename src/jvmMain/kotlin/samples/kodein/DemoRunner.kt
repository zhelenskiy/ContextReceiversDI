package samples.kodein

import samples.kodein.coffee.*

abstract class AbstractDemoRunner: LoggerProvider, PumpProvider, HeaterProvider, RationProvider<Ration> {
    override val pump: Pump by lazy(thermosiphonModule::pump)
    override val heater: Heater by lazy(electricHeaterModule::heater) 
    override fun makeRation(): Ration = Coffee()
    val kettle by lazy { Kettle() }
    val creator = "Evgeniy Zhelenskiy"
    val maintainer = "Evgeniy Zhelenskiy"
}

context (AbstractDemoRunner)
class KodeinMppApplication {
    init {
        logger.log("Kodein-DI Demo by $creator and $maintainer")
        kettle.brew()
    }
}
