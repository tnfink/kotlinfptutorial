package calculator.step2

// it does work
// immutable data,
// functions not procedures (e.g. no return operations)
// but you can do more with currying

data class CalculatorModel(val display: Int, val main: Int, val background: Int) {}

fun clickDigit(digit: Int, model: CalculatorModel): CalculatorModel =
    model.copy(display = model.display * 10 + digit) // immutable data

fun clickOne(model: CalculatorModel): CalculatorModel =
    clickDigit(1, model)

fun clickTwo(model: CalculatorModel): CalculatorModel =
    clickDigit(2, model)

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