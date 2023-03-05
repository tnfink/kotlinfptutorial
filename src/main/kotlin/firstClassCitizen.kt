data class Proband(val name: String)

typealias ProbandEvaluator = (Proband) -> Double

val lengthEvaluator : ProbandEvaluator =
    { proband: Proband -> proband.name.length.toDouble() }

val sortProbands: (Set<Proband>, ProbandEvaluator) -> List<Proband> =
    { probands: Set<Proband>,
      evaluator: ProbandEvaluator ->
        val evaluatedProbands = probands.map()
        { proband: Proband -> Pair(evaluator(proband), proband) }
        evaluatedProbands
            .sortedBy { pair -> pair.first }
            .map { pair -> pair.second }
    }

private fun createEvaluator() = lengthEvaluator

private fun loadProbands() = setOf(Proband("P333"), Proband("P1"), Proband("P22"))

//=============

fun doSomething(input:Int):Int = 0
fun doSomethingElse():Int = 0

fun doSeveralThings(input:Int) {
    val a = doSomething(input)
    doSomethingElse()
    val b = doSomething(input)
    // a == b
}

//=============

fun main() {
    val probands = loadProbands()
    val evaluator = createEvaluator()
    val sortedProbands = sortProbands(probands, evaluator)

    println("probands = ${probands}")
    println("sortedProbands = ${sortedProbands}")
}

