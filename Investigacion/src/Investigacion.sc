def integracion(f: Double => Double, a: Double, b: Double): Double = {
  val x: Double = (a + b) / 2
  (b - a) * (f(a) + 4 * f(x) + f(b)) / 6
}

def calcularError(valorEsperado: Double, valorObtenido: Double): Double = {
  Math.abs(valorEsperado - valorObtenido)
}

val f1: Double => Double = (x: Double) => -Math.pow(x, 2) + 8 * x - 12
val f2: Double => Double = (x: Double) => 3 * Math.pow(x, 2)
val f3: Double => Double = (x: Double) => x + 2 * Math.pow(x, 2) - Math.pow(x, 3) + 5 * Math.pow(x, 4)
val f4: Double => Double = (x: Double) => (2 * x + 1) / (Math.pow(x, 2) + x)
val f5: Double => Double = (x: Double) => Math.exp(x)
val f6: Double => Double = (x: Double) => 1 / Math.sqrt(x - 1)
val f7: Double => Double = (x: Double) => 1 / (1 + Math.pow(x, 2))

val ejercicios: List[(Int, Double => Double, Double, Double, Double)] = List(
  (1, f1, 3.0, 5.0, 7.33),
  (2, f2, 0.0, 2.0, 8.0),
  (3, f3, -1.0, 1.0, 3.333),
  (4, f4, 1.0, 2.0, 1.09861),
  (5, f5, 0.0, 1.0, 1.71828),
  (6, f6, 2.0, 3.0, 0.828427),
  (7, f7, 0.0, 1.0, 0.785398)
)

println(f"${"Ej."}%-5s | ${"Valor Obtenido"}%-15s | ${"Valor Esperado"}%-15s | ${"Error"}%-15s")
println("-" * 55)

ejercicios.map { e =>
  val id: Int = e._1
  val func: (Double => Double) = e._2
  val a: Double = e._3
  val b: Double = e._4
  val esperado: Double = e._5

  val obtenido: Double = integracion(func, a , b)
  val error: Double = calcularError(esperado, obtenido)
  println(f"$id%-5d | $obtenido%1.5f         | $esperado%1.5f         | $error%1.6f")
}
