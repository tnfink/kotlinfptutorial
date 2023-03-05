package integrationdemo

import kotlin.math.abs

fun integrateImperative(
    start: Double, end: Double, precision: Long,
    f: (Double) -> Double
): Double {
    val step = (end - start) / precision
    var result = 0.0
    var x = start
    for (i in 0 until precision) {
        result += f(x) * step
        x += step
    }
    return result
}

fun integrateFunctional(
    start: Double, end: Double, precision: Long,
    f: (Double) -> Double
): Double {
    return 0.0

}

fun main() {
    val square = { x: Double -> x * x }

    assertNearlyEq(
        integrateImperative(-1.0, 1.0, 100, square),
        integrateFunctional(-1.0, 1.0, 100, square),
    )
    assertNearlyEq(
        integrateImperative(-15.0, 0.0, 1000, square),
        integrateFunctional(-15.5, 0.0, 1000, square),
    )
}

fun  assertNearlyEq(expected: Double, actual: Double) {
    if (abs(expected - actual) < 0.000001) {
        println("Check")
    } else {
        println("Expected ${expected} but it is ${actual}")
    }
}