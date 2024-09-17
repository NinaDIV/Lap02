package Acuario

interface AccionPez {
    fun comer()
}

abstract  class Pez {
    abstract val color: String
    init {
        println("////////////////////////////////////")
        println("Inicializando Pez")
    }
}
class Tiburon : Pez() {
    // Implementación de la propiedad color
    override val color: String
        get() = "gris"
}

// Clase PezPayaso que hereda de Pez
class PezPayaso : Pez() {
    // Implementación de la propiedad color
    override val color: String
        get() = "dorado"
}

