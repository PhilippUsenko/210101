import kotlin.math.sqrt

fun generateFibonacci(n: Int): List<Int> {
    val fibList = mutableListOf(0, 1)
    while (true) {
        val nextFib = fibList[fibList.size - 1] + fibList[fibList.size - 2]
        if (nextFib > n) break
        fibList.add(nextFib)
    }
    return fibList
}

fun eratosthenes(limit: Int): List<Boolean> {
    val isPrime = MutableList(limit + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..sqrt(limit.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..limit step i) {
                isPrime[j] = false
            }
        }
    }
    return isPrime
}

fun main() {
    var n: Int? = null

    while (n == null) {
        println("Введите число N:")
        n = readlnOrNull()?.toIntOrNull()
        if (n == null) {
            println("Некорректный ввод. Пожалуйста, введите целое число.")
        }
    }

    val fibonacciNumbers = generateFibonacci(n)
    println("Числа Фибоначчи до $n: $fibonacciNumbers")

    val primes = eratosthenes(fibonacciNumbers.last())

    println("Простые числа Фибоначчи:")
    for (fib in fibonacciNumbers) {
        if (fib <= n && primes[fib]) {
            print("$fib ")
        }
    }
}
