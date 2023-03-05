package calculator.step4

// it starts to feel like functional programming
// one more step

data class CalculatorModel(val display: Int, val main: Int, val background: Int) {}

val clickDigit: (Int) -> (CalculatorModel) -> CalculatorModel =
    { digit -> { model ->
            model.copy(display = model.display * 10 + digit)
    }}

val clickOne = clickDigit(1)
val clickTwo= clickDigit(2)

fun main() {
    val model = CalculatorModel(12, 0, 0)

    val modelClickedOn = clickOne(model)
    assertEq(121, modelClickedOn.display)

    val modelClickedTwo = clickTwo(model)
    assertEq(122, modelClickedTwo.display)
}

fun <T> assertEq(expected: T, actual: T) {
    if (expected!!.equals(actual)) {
        println("Check")
    } else {
        println("Expected ${expected} but it is ${actual}")
    }
}