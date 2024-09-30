fun <T> filterList(data: List<T>, predicate: (T) -> Boolean): List<T> {
    return data.filter(predicate)
}

fun <T, R> transformList(data: List<T>, transformer: (T) -> R): List<R> {
    return data.map(transformer)
}

fun sumList(data: List<Int>): Int {
    return data.sum()
}

fun averageList(data: List<Int>): Double {
    return if (data.isNotEmpty()) data.average() else 0.0
}

fun maxList(data: List<Int>): Int? {
    return data.maxOrNull()
}

fun minList(data: List<Int>): Int? {
    return data.minOrNull()
}

fun filterLongWords(words: List<String>, length: Int): List<String> {
    return words.filter { it.length > length }
}

fun main() {
    println("Введите числа через пробел:")
    val input = readlnOrNull()

    val numbers = input?.split(" ")?.mapNotNull {
        it.toIntOrNull()
    } ?: emptyList()

    if (numbers.isEmpty()) {
        println("Некорректный ввод. Пожалуйста, введите хотя бы одно число.")
        return
    }
    val evenPredicate: (Int) -> Boolean = { it % 2 == 0 }

    val tripleTransformer: (Int) -> Int = { it * 3 }

    val evenNumbers = filterList(numbers, evenPredicate)
    println("Четные числа: $evenNumbers")

    val tripledNumbers = transformList(evenNumbers, tripleTransformer)
    println("Тройные четные числа: $tripledNumbers")

    val sumResult = sumList(tripledNumbers)
    println("Сумма тройных четных чисел: $sumResult")

    val averageResult = averageList(tripledNumbers)
    println("Среднее значение тройных четных чисел: $averageResult")

    val maxResult = maxList(tripledNumbers)
    println("Максимальное значение: $maxResult")

    val minResult = minList(tripledNumbers)
    println("Минимальное значение: $minResult")

    val words = listOf("cat", "elephant", "dog", "rhinoceros", "fox")
    val longWords = filterLongWords(words, 3)
    println("Слова длиной больше 3 символов: $longWords")
}
