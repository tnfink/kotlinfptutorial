data class Article(val price: Double)

fun sumWithDiscountImp(
    article1: Article,
    article2: Article,
    discount: Double
): Double {
    var ergebnis = 0.0
    ergebnis += article1.price
    ergebnis += article2.price
    ergebnis *= (1.0 - discount)
    return ergebnis
}


val sumWithDiscountFP =
    { article1: Article,
      article2: Article,
      discount: Double ->
        val sumArticles =
            article1.price + article2.price
        val discountMultiplier =
            1.0 - discount
        discountMultiplier *
                sumArticles
    }


// ==========================

data class PriceM(
    var amount: Double
) {}

data class ConferenceM(
    var name: String,
    var price: PriceM
) {}

fun createDeveloperConferencesM() {
    val developersEpisode1 = ConferenceM(
        "Developers - Episode 1",
        PriceM(200.0)
    )
    val developersEpisode2 = ConferenceM(
        "Developers - Episode 2",
        developersEpisode1.price
    )
    // later in the code ...
    // compute a discount for participant of
    // both conferences
    developersEpisode2.price.amount *= 0.5

    val ticketFee =
        developersEpisode1.price.amount +
                developersEpisode2.price.amount

    println("Mutable")
    println("${developersEpisode1}")
    println("${developersEpisode2}")
    println("ticketFee = ${ticketFee}")
}

data class PriceIM(
    val amount: Double
) {}

data class ConferenceIM(
    val name: String,
    val price: PriceIM
) {}

fun createDeveloperConferencesIM() {
    val developersEpisode1 = ConferenceIM(
        "Developers - Episode 1",
        PriceIM(200.0)
    )
    val developersEpisode2 =
        developersEpisode1.copy(
            name = "Developers - Episode 2"
        )

    // ...
    // compute discount for participants of
    // both conferences
    val discountedPrice = developersEpisode2
        .price
        .copy(developersEpisode2.price.amount / 2)
    val developersEpisode2Discounted =
        developersEpisode2.copy(
            price = discountedPrice
        )

    val ticketFee =
        developersEpisode1.price.amount +
                developersEpisode2Discounted.price.amount

    println("Immutable")
    println("${developersEpisode1}")
    println("${developersEpisode2Discounted}")
    println("ticketFee = ${ticketFee}")
}


fun main() {
    createDeveloperConferencesM()
    println()
    createDeveloperConferencesIM()
}