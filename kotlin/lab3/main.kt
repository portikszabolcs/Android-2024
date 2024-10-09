package lab3

data class Item(val question: String, val answers: List<String>, val correct: Int)

fun main() {
    val quizController = ItemController(ItemService(ItemRepository))
    quizController.quiz(5)
}