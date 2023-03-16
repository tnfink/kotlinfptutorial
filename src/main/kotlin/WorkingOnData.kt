package workingondata

data class Employee(val name:String, val salary:Int)

val employees = listOf(
    Employee("Mr. Smith", 3500),
    Employee("Mrs. Smith", 5000))

// todo salaries (map)

// todo sumOfSalaries (fold)

fun main() {
    println("employees = ${employees}")
}