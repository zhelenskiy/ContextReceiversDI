package samples.kodein.coffee

interface Pump {
    fun pumpWater()
}

interface PumpProvider {
    val pump: Pump
}
