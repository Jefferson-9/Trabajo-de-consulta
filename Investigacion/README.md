# Implementación de la Regla de Simpson 1/3 en Scala
## 1. Descripción del Proyecto
Este proyecto tiene como objetivo aplicar los principios de la **Programación Funcional** para resolver problemas matemáticos de integración numérica. Se implementó el algoritmo de la **Regla de Simpson 1/3** utilizando **Funciones de Orden Superior** en Scala.
El objetivo es crear una solución genérica que pueda aproximar el área bajo la curva de cualquier función matemática *f(x)* dada.
## 2. Marco Teórico: Regla de Simpson 1/3
La aproximación de la integral definida se calcula mediante la fórmula:
$$\int_{a}^{b}f(x)dx \cong (b-a) \frac{f(a) + 4f(\overline{x}) + f(b)}{6}$$
Donde:
* *a* y *b*: Límites inferior y superior de la integración
* $\overline{x} = \frac{a+b}{2}$: Punto medio del intervalo.
## 3. Arquitectura del Código
### 3.1 Función de orden Superior (`integracion`)
La pieza central del proyecto es la función `integracion`. Se considera de Orden Superior porque recibe otra función como parámetro (`f`).
```scala
def integracion(f: Double => Double, a: Double, b: Double): Double = {
  val x: Double = (a + b) / 2
  (b - a) * (f(a) + 4 * f(x) + f(b)) / 6
} 
```
* **Entrada:** Recibe el comportamiento matemático `f` (tipo `Double => Double`) y los límites `a` y `b`.
* **Proceso:** Evalúa la función `f` en los puntos clave ($a, \overline{x}, b$) sin conocer la lógica interna `f`.
* **Salida:** Retorna el valor aproximado del área (tipo `Double`).
### 3.2 Tipado Estricto
Para garantizar la robustez del software, se utilizó **Tipado Estricto** en todo el proyecto. No se utilizó inferencia de tipos en las definiciones clave.
Ejemplo:
```scala 
val f1: Double => Double = (x: Double) => -Math.pow(x, 2) + 8 * x - 12 
```
Esto asegura que la variable `f` cumpla estrictamente con la firma que espera la función de integración.
### 3.3 Cálculo del Error
Para validar la precisión del método, se calcula el error absoluto entre el valor aproximado y el valor esperado:
  ```scala
def calcularError(valorEsperado: Double, valorObtenido: Double): Double = {
  Math.abs(valorEsperado - valorObtenido)
} 
```
## 4. Resultados Obtenidos
Se realizaron pruebas con 7 funciones matemáticas distintas. A continuación se presentan los resultados obtenidos:

| Ej. | Valor Obtenido | Valor Esperado | Error Absoluto |
| :---: | :---: | :---: | :---: |
| 1 | 7,33333 | 7,33000 | 0,003333 |
| 2 | 8,00000 | 8,00000 | 0,000000 |
| 3 | 4,66667 | 3,33300 | 1,333667 |
| 4 | 1,10000 | 1,09861 | 0,001390 |
| 5 | 1,71886 | 1,71828 | 0,000581 |
| 6 | 0,82885 | 0,82843 | 0,000422 |
| 7 | 0,78333 | 0,78540 | 0,002065 |

**Análisis de Resultados**
* **Precisión:** En funciones polinómicas de grado 2 o inferior (como el `Ejercicio 2`) el método de Simpson 1/3 es exacto (Error = 0.0)
* **Margen de Error:** En funciones más complejas o de grado superior (como el `Ejercicio 3`, grado 4), se presenta un margen de error natural debido a que se aplicó Simpson simple.
## 5. Conclusiones
* El uso de Funciones de Orden Superior permitió desacoplar la lógica de integración de las ecuaciones matemáticas específicas, resultando en un código reutilizable y modular.
* El **Tipado Estricto** facilita la lectura del código y previene errores en tiempo de compilación al asegurar que los datos fluyan con la estructura correcta.
## 6. Uso de la IA
Utilice la IA Generativa como herramienta de apoyo para la revisión de código y la refactorización hacia un tipado estricto, asegurando así la robustez y calidad del código final.
Usé el siguiente **prompt:**
`Actúa como un Ingeniero de Software Senior experto en Scala y Programación Funcional.`
`Estoy desarrollando un código en Scala para resolver integrales numéricas usando la Regla de Simpson 1/3 como parte de mi asignatura universitaria. La lógica matemática y la estructura de funciones de orden superior ya están implementadas y funcionan.`
`Necesito que realices la Revisión de Código que está enfocado en la robustez. Toma mi código base y refactorízalo cumpliendo estrictamente con los siguientes requisitos:`
`1. Tipado Estricto: Elimina cualquier inferencia de tipos, quiero que declares explícitamente el tipo de dato en todas las variables, parámetros de funciones, valores de retorno y dentro de las funciones anónimas (lambdas) e iteradores (map).`
`2. Verificación de Sintaxis: Asegúrate de que la sintaxis de Scala sea limpia y siga las convenciones estándar.`
`3. No cambies la lógica: Mantén la fórmula matemática de Simpson tal como la he escrito, solo mejora la definición del código.`
**Mi código es el siguiente:**
```scala
ejercicios.map { e =>
    val id = e._1   
    val func = e._2    
    val a = e._3
    val b = e._4
    val esperado = e._5

    val obtenido = integracion(func, a, b)
    val error = calcularError(esperado, obtenido)

    println(f"$id%-5d | $obtenido%1.5f         | $esperado%1.5f         | $error%1.6f")
  }
```
Así mismo con los demás fragmentos de código donde necesitaba verificar que este correctamente el tipado y la sintaxis.
## 7. Referencias Bibliográficas 
1. **Cátedra de Programación Funcional y Reactiva.** (2025). *Trabajo de consulta: Higher Order Functions - Integración Numérica*. Universidad Técnica Particular de Loja (UTPL). Consultado para: Planteamiento del problema y ecuaciones matemáticas.
2. **Chapra, S. C., & Canale, R. P.** (2015). *Métodos numéricos para ingenieros* (7a ed.). McGraw-Hill Education. Consultado para: Teoría del error y Regla de Simpson 1/3.
3. **Odersky, M., Spoon, L., & Venners, B.** (2016). *Programming in Scala* (3a ed.). Artima Press. Consultado para: Sintaxis de Scala y Funciones de Orden Superior.
4. **Matemáticas Piña Profe Piña.** (2020, 19 mayo). *Método de Simpson 1/3* Video. YouTube. https://www.youtube.com/watch?v=I1dWC7BHcIE
