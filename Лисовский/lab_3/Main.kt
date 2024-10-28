import java.util.Scanner

fun <A, R> memoize(function: (A) -> R): (A) -> R {
    val cache = mutableMapOf<A, R>()
    return { input ->
        cache.getOrPut(input) { function(input) }
    }
}

fun fibonacci(n: Int): Long {
    if (n == 0) return 0
    if (n == 1) return 1
    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {
    val scanner = Scanner(System.`in`)
    val memoizedFibonacci = memoize(::fibonacci)

    while (true) {
        println(
            "1 - для ручного ввода" +
                    "\n2 - автоматическое вычисление 40 чисел Фибоначчи" +
                    "\n0 - выход из программы"
        )

        val choice = scanner.nextLine()

        if (choice == "0") {
            println("Программа завершена.")
            break
        }

        if (choice == "1") {
            println("Введите количество чисел Фибоначчи для вычисления:")
            val input = scanner.nextLine()
            val count = input.toIntOrNull()
            if (count == null || count < 0) {
                println("Неверный ввод. Пожалуйста, введите положительное число.")
            } else {
                for (i in 0 until count) {
                    println("Fibonacci($i) = ${memoizedFibonacci(i)}")
                }
            }
        } else if (choice == "2") {
            println("Вычисление 40 чисел Фибоначчи:")
            for (i in 0..40) {
                println("Fibonacci($i) = ${memoizedFibonacci(i)}")
            }
        } else {
            println("Неверный ввод. Пожалуйста, введите 1, 2 или 0 для выхода.")
        }
    }
}
