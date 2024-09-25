import kotlin.math.sqrt
import kotlin.random.Random

fun main() {
    // 1.
    val a = 1
    val b = 3
    
    println("$a + $b = ${a+b}")
    println()
    
    // 2.
    val daysOfWeek = listOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
    	"Saturday", "Sunday"
    )
    
    for(day: String in daysOfWeek) {
        println(day)
    }
    println()
    
    daysOfWeek.filter { it.startsWith("T")}.forEach {
        println(it)
    }
    println()
    
    daysOfWeek.filter { it.contains("e")}.forEach {
        println(it)
    }
    println()
    
    daysOfWeek.filter { it.length == 6 }.forEach {
        println(it)
    }
    println()
    
    // 3.
    for (i in 1..100) {
        if(isPrime(i)) print("$i, ")
    }
    println()
    
    // 4.
    val message = "Alma"
    val res = messageCoding(message, ::encode)
    
    println()
    println(res)
    println(messageCoding(res, ::decode))
    println()
    
    // 5.
    val list = listOf(1,2,3,4,5,6,7,8,9)
    evenNumbers(list)
    println()
    println()
    
    // 6.
    println(list.map { it * 2 })
    println(daysOfWeek.map { it.uppercase() })
    println(daysOfWeek.map { it.capitalize() })
    val lengths = daysOfWeek.map { it.length }
    println(lengths)
    println(lengths.sum().toDouble() / lengths.size)
    println()
    
    // 7.
    val daysMutable = daysOfWeek.toMutableList()
    daysMutable.removeIf { it.contains('n')}
    println(daysMutable)
    for((index: Int, day: String) in daysMutable.withIndex()) {
        println("Item at $index is $day")
    }
    daysMutable.sort()
    println(daysMutable)
    println()
    
    // 8.
    val intList = IntArray(10) { Random.nextInt(0, 100) }
    intList.forEach { println(it) }
    println("\nSorting...")
    intList.sort()
    intList.forEach { println(it) }
    
    if(intList.any { it % 2 == 0 }) println("The list contains at least one even number.")
    else println("The list does not contain even number.")
    
    if(intList.all { it % 2 == 0 }) println("The list contains only even numbers.")
    else println("The list does not contain only even numbers.")
    
    println(intList.sum().toDouble() / intList.size)
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    val sqrt = sqrt(num.toDouble()).toInt()
    return (2..sqrt).none { num % it == 0 }
}

fun evenNumbers(list: List<Int>) = list.filter { it % 2 == 0 }.forEach { print("$it, ")}

fun encode(msg: String): String = msg.map { it + 15 }.joinToString("")

fun decode(msg: String): String = msg.map { it - 15 }.joinToString("")

fun messageCoding(msg: String, func: (String) -> String): String = func(msg)
