import kotlin.random.Random

fun main() {
    val list = (1..100).toList()

    val sumForEach = sumWithForEach(list)

    val sumFold = list.fold(0) { acc, n -> acc + n }

    println("${sumForEach}")
    println("${sumFold}")

    val personen = listOf(Person(), Person(), Person(), Person(), Person())

    val election = waehleZufaelligeTeilnehmerAus(personen, 50)
    val electionFP = waehleZufaelligeTeilnehmerAusFP(personen, 50, RandomFP(0))
    println("$election")
    println("$electionFP")
}

private fun sumWithForEach(list: List<Int>): Int {
    var sum = 0
    list.forEach { n -> sum += n }
    return sum
}

data class Bestellartikel(
    val artikelNummer: String,
    val preis: Int
)

fun sumImperativ(items: List<Bestellartikel>): Int {
    var result = 0
    for (i in 0 until items.size) {
        result += items[i].preis
    }
    return result
}

fun summierePreise(items: List<Bestellartikel>): Int =
    items
        .map(Bestellartikel::preis)
        .sum()


class Person {}

fun waehleZufaelligeTeilnehmerAus(
    personen: List<Person>,
    quoteInProzent: Int
): List<Person> =
    personen
        .filter { (0..99).random() < quoteInProzent }

class RandomFP(val seed: Int) {
    fun nextInt(min: Int, max: Int) = Pair(
        (min..max).random(Random(seed)),
        RandomFP(seed + 1)
    )
}

fun waehleZufaelligeTeilnehmerAusFP(
    personen: List<Person>,
    quoteInProzent: Int,
    random: RandomFP
): List<Person> =
    personen
        .fold<Person, Pair<List<Person>, RandomFP>>(
            Pair(emptyList<Person>(), random)
        )
        { (accList, rnd), person ->
            val (randomNumber, rnd2) = rnd.nextInt(0, 99)
            println("randomNumber: $randomNumber")
            if (randomNumber < quoteInProzent)
                Pair(accList.plus(person), rnd2)
            else
                Pair(accList, rnd2)
        }.first