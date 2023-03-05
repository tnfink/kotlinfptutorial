
val adder : (Int) -> (Int) -> Int = { x -> { y ->
    x + y
}}

val adderUncurried = {x : Int, y : Int -> x+y }

val add1FromUncurried = {y: Int -> adderUncurried(1,y)}

val adderCurryAdapter : (Int) -> (Int) -> Int = { x-> { y-> adderUncurried(x,y)}}

val add1 = adder(1)

val add1FromAdapter = adderCurryAdapter(1)

fun playWithAdding() {
    println("adder 1 2 = ${adder(1)(2)}")
    println("add1FromUncurried(2) = ${add1FromUncurried(2)}")
    println("add1 2 = ${add1(2)}")
    println("add1FromAdapter 2 = ${add1FromAdapter(2)}")
}

// ===========


fun main() {
    playWithAdding();
}