package workingondata

data class Employee(val name:String, val salary:Int)

val employees = listOf(
    Employee("Mr. Smith", 3500),
    Employee("Mrs. Smith", 5000))

// Map

val salaries = employees.map({employee -> employee.salary})

val salaries1 = employees.map() {employee -> employee.salary}

val salaries2 = employees.map { employee -> employee.salary}

val salaries3 = employees.map { (_, salary) -> salary}

val salaries4 = employees.map { it.salary}

val salaries5 = employees.map(Employee::salary)

// fold

val sumOfSalaries = salaries.fold(0) {acc, salary -> acc + salary}

val sumOfSalaries2 = salaries.sum()

// Pipe

fun computeSumOfSalaries(salaries : List<Employee>) =
    salaries
        .map {it.salary}
        .sum()

// funktionaler wird es hier nicht

fun main() {
    println("employees = ${employees}")
    println("salaries = ${salaries}")
    println("salaries1 = ${salaries1}")
    println("salaries3 = ${salaries3}")
    println("salaries4 = ${salaries4}")
    println("salaries5 = ${salaries5}")
    println("sumOfSalaries = ${sumOfSalaries}")
    println("sumOfSalaries2 = ${sumOfSalaries2}")
}