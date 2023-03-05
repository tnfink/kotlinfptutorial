import org.junit.jupiter.api.Test

internal class ImmutableExamplesKtTest {

    @Test
    fun berechneSumme() {
        val article1 = Article(2.5)
        val article2 = Article(4.5)
        val rabatt = 0.1

        assert(
            sumWithDiscountFP(article1, article2, rabatt) ==
                    sumWithDiscountImp(article1, article2, rabatt)
        )
    }
}