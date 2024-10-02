package lab2

import java.io.File

object ListDictionary : IDictionary {
    private val words = mutableListOf<String>()

    init {
        File(IDictionary.PATH).forEachLine { words.add(it) }
    }

    override fun add(word: String): Boolean {
        return words.add(word)
    }

    override fun find(word: String): Boolean {
        return words.find { it == word } != null
    }

    override fun size(): Int {
        return words.size
    }
}