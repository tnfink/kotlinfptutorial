package calculator.step6

// with solution

data class CalculatorModel(val display: Int, val main: Int) {}

val clickDigit: (Int) -> (CalculatorModel) -> CalculatorModel =
    { digit -> { model ->
            model.copy(display = model.display * 10 + digit)
    }}

val clickOne = clickDigit(1)
val clickTwo= clickDigit(2)

val clickPlus : (CalculatorModel) -> CalculatorModel =
    { model ->
        model.copy(
            display = 0,
            main = model.display + model.main)}

fun main() {
    testClickDigits()
    testClickPlus()
}

private fun testClickPlus() {
    val model = CalculatorModel(123, 100)
    val modelClickedPlus = clickPlus(model)
    assertEq(0, modelClickedPlus.display)
    assertEq(223, modelClickedPlus.main)
}

private fun testClickDigits() {
    val model = CalculatorModel(12, 0)

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