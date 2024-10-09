package lab3

import java.io.File

object ItemRepository {
    val items = mutableListOf<Item>()

    init {
        val lines = File("/mnt/Adatok/IT/draft/lab3/quiz.txt").readLines()
        var i = 0
        while (i<lines.size) {
            val question = Item(lines[i], mutableListOf(lines[i+1], lines[i+2], lines[i+3], lines[i+4]), lines[i+5].toInt())
            items.add(question)
            i += 7
        }
    }

    fun randomItem() = items.random()

    fun save(item: Item) = items.add(item)

    fun size() = items.size
}