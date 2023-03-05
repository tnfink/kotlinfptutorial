package calculator.step3

// it starts to feel like functional programming
// one more step

data class CalculatorModel(val display: Int, val main: Int, val background: Int) {}

val clickDigit: (Int) -> (CalculatorModel) ->  CalculatorModel =
    { digit -> { model ->
            model.copy(display = model.display * 10 + digit)
    }}

fun clickOne(model: CalculatorModel): CalculatorModel = clickDigit(1)(model)

fun clickTwo(model: CalculatorModel): CalculatorModel = clickDigit(2)(model)

fun main() {
    val model = calculator.step4.CalculatorModel(12, 0, 0)

    val modelClickedOn = calculator.step4.clickOne(model)
    assertEq(121, modelClickedOn.display)

    val modelClickedTwo = calculator.step4.clickTwo(model)
    assertEq(122, modelClickedTwo.display)
}

fun <T> assertEq(expected: T, actual: T) {
    if (expected!!.equals(actual)) {
        println("Check")
    } else {
        println("Expected ${expected} but it is ${actual}")
    }
}