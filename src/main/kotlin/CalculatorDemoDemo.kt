package calculator.demo

data class CalculatorModel(val display: Int, val main: Int, val background: Int) {}

fun clickOne(model: CalculatorModel): CalculatorModel {
    return model;
}

fun clickTwo(model: CalculatorModel): CalculatorModel {
    return model;
}

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