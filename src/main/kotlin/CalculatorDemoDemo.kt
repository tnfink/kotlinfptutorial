package calculator.demo


data class CalculatorModel(val display: Int, val main: Int) {}

fun clickOne(model: CalculatorModel): CalculatorModel {
    return model;
}

fun clickTwo(model: CalculatorModel): CalculatorModel {
    return model;
}

fun clickPlus(model: CalculatorModel): CalculatorModel {
    return model
}

fun main() {
    testClickDigits()
    testClickPlus()
}

private fun testClickDigits() {
    val model = CalculatorModel(12, 0)

    val modelClickedOn = clickOne(model)
    assertEq(121, modelClickedOn.display)

    val modelClickedTwo = clickTwo(model)
    assertEq(122, modelClickedTwo.display)
}

private fun testClickPlus() {
    val model = CalculatorModel(123, 100)
    val modelClickedPlus = clickPlus(model)
    assertEq(0, modelClickedPlus.display)
    assertEq(223, modelClickedPlus.main)
}


fun <T> assertEq(expected: T, actual: T) {
    if (expected!!.equals(actual)) {
        println("Check")
    } else {
        println("Expected ${expected} but it is ${actual}")
    }
}