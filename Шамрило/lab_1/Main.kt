import kotlin.random.Random

fun main() {
    val randomNumber: Int = Random.nextInt(1000, 10000)
    //println(randomNumber)
    val ra = randomNumber / 1000
    val rb = randomNumber / 100 % 10
    val rc = randomNumber / 10 % 10
    val rd = randomNumber % 10

    var cv = "1"
    while (cv == "1"){
        println("Введите четырёхзначное число")
        var number: Int? = null
        while (number == null || number < 1000 || number > 9999) {
            val inputNumber = readln()
            number = inputNumber?.toIntOrNull()
            if (number == null){
                println("Введите число: ")
            }else if(number < 1000 || number > 9999){
                println("Введите корректное число: ")
            }
        }
        if (number == randomNumber) {
            println("Вы победили!!!")
            break
        } else {
            val a = number / 1000
            val b = number / 100 % 10
            val c = number / 10 % 10
            val d = number % 10

            val randomNumbers = mutableListOf<Int>(ra, rb, rc, rd)
            val numbers = mutableListOf<Int>(a, b, c, d)
            var correctNumber = 0
            var correctPosition = 0

            for (i in randomNumbers.indices) {
                if (randomNumbers[i] == numbers[i]) {
                    correctPosition++
                    randomNumbers[i] = -1
                    numbers[i] = -2
                }
            }
            for (num in numbers) {
                if (num != -2 && randomNumbers.contains(num)) {
                    correctNumber++
                }
            }

            println("Количество правильных цифр, но не на своих местах: $correctNumber")
            println("Количество совпадений: $correctPosition")
        }
        println("\n1 - продолжить угадывать\nдругое - завершить")
        cv = readln()
    }
}
