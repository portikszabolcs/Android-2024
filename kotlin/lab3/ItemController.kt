package lab3

class ItemController(private val itemService: ItemService) {
    fun quiz(numOfQuestions: Int) {
        var correct = 0
        val questions = itemService.selectRandomItems(numOfQuestions)
        if (questions.isEmpty()) {
            println("Invalid number of questions, please try again with a different number")
            return
        }
        questions.forEach {
            println(it.question)
            it.answers.forEachIndexed() { index, item ->
                print("${index+1}.$item\t")
            }
            println()
            print("Select an answer: ")
            val ans = readlnOrNull()
            if (ans?.toIntOrNull() == it.correct) {
                correct++
                println("Correct answer!")
            } else {
                println("Incorrect answer")
            }
            println()
        }
        println("Correct answers: $correct/$numOfQuestions")
        if(correct == numOfQuestions) println("Congratulations, you are the boss!")
    }
}