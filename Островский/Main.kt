import kotlin.random.Random

fun getRandomWord(level: Int): String {
    val words = when (level) {
        1 -> listOf("кот", "душ", "мат")
        2 -> listOf("яблык", "кавун", "слова")
        3 -> listOf("ноутбук", "пацыфіст", "праграма")
        else -> listOf("сельскагаспадарчы")
    }
    return words[Random.nextInt(words.size)]
}

fun getHint(word: String, guessedLetters: List<Char>): String {
    return word.map { char ->
        if (guessedLetters.contains(char)) char else '_'
    }.joinToString(" ")
}

fun playGame() {
    println("Выберыце ўзровень цяжкасці: \n1 - Лёгкі \n2 - Сярэжні \n3 - Цяжкі \n4 - Экспертны")
    val level = readLine()?.toIntOrNull() ?: 1
    val word = getRandomWord(level)
    val guessedLetters = mutableListOf<Char>()
    var attempts = 10

    println("Адгадайце слова! \nСлова складаецца з ${word.length} літар.")

    while (attempts > 0) {
        println("Падказка: ${getHint(word, guessedLetters)}")
        println("Увядзіце літару або слова (засталося спробаў: $attempts):")
        val input = readLine() ?: ""

        if (input.length == 1) {
            val letter = input[0]
            if (word.contains(letter)) {
                println("Правільная літара!")
                guessedLetters.add(letter)
            } else {
                println("Няправільная літара.")
                attempts--
            }
        } else if (input.length == word.length && input == word) {
            println("Віншую! Вы адгадалі слова: $word")
            return
        } else {
            println("Некарэктны ўвод.")
        }

        if (word.all { guessedLetters.contains(it) }) {
            println("Віншую! Вы адгадалі слова: $word")
            return
        }
    }

    println("Гульня скончана. Слова было: $word")
}

fun main() {
    playGame()
}