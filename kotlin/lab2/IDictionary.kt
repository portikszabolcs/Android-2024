package lab2

interface IDictionary {
    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int

    companion object {
        const val PATH = "/mnt/Adatok/IT/draft/lab2/dict.txt"
    }
}