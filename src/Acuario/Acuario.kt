package Acuario
import kotlin.math.PI

open class Acuario(var largo: Int = 100, var ancho: Int = 20, var alto: Int = 40){

    // Bloque init para inicializar la clase
    init {
        println("////////////////////////////////////")
        println("Inicializando acuario")
    }

    open var volumen: Int
        get() = ancho * alto * largo / 1000  // 1000 cm^3 = 1 l
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    open val forma = "rectángulo"

    open var agua: Double
        get() = volumen * 0.9
        set(valor) {
            // Este setter no tiene sentido en el contexto actual
            // El getter se actualiza dinámicamente basado en el volumen
        }

    // Constructor secundario
    constructor(numeroDePeces: Int) : this() {
        val volumenNecesario = numeroDePeces * 2000 * 1.1
        println("Volumen necesario para $numeroDePeces peces: $volumenNecesario cm^3")
        alto = (volumenNecesario / (largo * ancho)).toInt()
        println("Nuevo alto calculado: $alto cm")
    }

    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm " +
                "Largo: $largo cm " +
                "Alto: $alto cm ")
        println("Volumen: $volumen l Agua: $agua l (${agua / volumen * 100.0}% lleno)")
    }
}

class TanqueTorre(alto: Int, var diametro: Int) : Acuario(largo = diametro, ancho = diametro, alto = alto) {
    override var volumen: Int
        get() = (diametro / 2 * diametro / 2 * alto * PI).toInt() // Corregido
        set(valor) {
            alto = ((valor * 1000) / (PI * (diametro / 2) * (diametro / 2))).toInt() // Corregido
        }

    override var agua: Double
        get() = volumen * 0.8
        set(valor) {
            // Este setter no tiene sentido en el contexto actual
            // El getter se actualiza dinámicamente basado en el volumen
        }

    override val forma = "cilindro"
}
