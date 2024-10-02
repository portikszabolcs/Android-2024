package lab2

fun main(){
//    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
//    println("Number of words: ${dict.size()}")
//    var word: String?
//    while(true){
//        print("What to find? ")
//        word = readlnOrNull()
//        if( word.equals("quit")){
//            break
//        }
//        println("Result: ${word?.let { dict.find(it) }}")
//    }

    println("Portik Szabolcs".monogram())

    val stringList = mutableListOf("alma", "korte", "szilva", "ribizli", "eper")
    println(stringList.joinBySeparator("#"))
    println(stringList.getLongest())
}

fun String.monogram(): String = split(" ").map { it.first() }.joinToString("")
fun List<String>.joinBySeparator(separator: String): String = joinToString(separator)
fun List<String>.getLongest(): String = maxBy { it.length }