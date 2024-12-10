import kotlin.random.Random

fun main() {
    val array = mutableListOf<Int>()


    println("Введите целые числа для сортировки (введите '0' для завершения):")
    while (true) {
        print("Введите число: ")
        val input = readLine() ?: break
        if (input.lowercase() == "0") break


        val number = input.toIntOrNull()
        if (number != null) {
            array.add(number)
        } else {
            println("Ошибка: введите корректное целое число.")
        }
    }

    if (array.isEmpty()) {
        println("Массив не может быть пустым. Завершение программы.")
        return
    }

    val sortedArray = array.sortedDescending()


    val evenNumbers = sortedArray.filter { it % 2 == 0 }.toMutableList()
    val oddNumbers = sortedArray.filter { it % 2 != 0 }.toMutableList()


    evenNumbers.shuffle(Random)
    oddNumbers.shuffle(Random)


    val resultArray = mutableListOf<Int>()
    for (num in sortedArray) {
        if (num % 2 == 0) {
            resultArray.add(evenNumbers.removeAt(0))
        } else {
            resultArray.add(oddNumbers.removeAt(0))
        }
    }
    println("Массив после сортировки по убыванию: ${sortedArray.joinToString()}")


    println("Итоговый массив: ${resultArray.joinToString()}")
}
