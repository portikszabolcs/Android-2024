package lab2

import kotlin.random.Random

fun main() {
    val dates = mutableListOf<Date>()

    println("Invalid dates:")
    while (dates.size < 10) {
        val date = Date(Random.nextInt(1950, 2050), Random.nextInt(0, 15), Random.nextInt(0, 50))
        if (date.isValid()) dates.add(date)
        else println(date)
    }

    println("\nValid dates:")
    dates.forEach { println(it) }

    dates.sort()
    println("\nSorted dates:")
    dates.forEach { println(it) }

    dates.sortDescending()
    println("\nReverse sorted dates:")
    dates.forEach { println(it) }

    dates.sortWith (Comparator<Date> {
        a: Date, b: Date -> a.day - b.day
    })
    println("\nDates sorted by day:")
    dates.forEach { println(it) }
}