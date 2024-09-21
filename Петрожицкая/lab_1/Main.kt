import java.util.Stack

fun calculateRPN(expression: String): Double? {
    val stack = Stack<Double>()
    val tokens = expression.split(" ")

    for (token in tokens) {
        when {
            token.toDoubleOrNull() != null -> {

                stack.push(token.toDouble())
            }
            token in listOf("+", "-", "*", "/") -> {
          
                if (stack.size < 2) {
                    println("Некорректный ввод: недостаточно операндов для операции '$token'")
                    return null
                }
                val b = stack.pop()
                val a = stack.pop()


                val result = when (token) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> {
                        if (b == 0.0) {
                            println("Ошибка: деление на ноль")
                            return null
                        }
                        a / b
                    }
                    else -> {
                        println("Некорректная операция: $token")
                        return null
                    }
                }
                // Помещаем результат обратно в стек
                stack.push(result)
            }
            else -> {
                println("Некорректный ввод: неизвестный символ '$token'")
                return null
            }
        }
    }

    // Проверяем, что после всех операций остался ровно один результат
    return if (stack.size == 1) {
        stack.pop()
    } else {
        println("Некорректный ввод: слишком много или слишком мало операндов")
        null
    }
}

fun main() {
    println("Введите выражение в обратной польской записи:")
    val input = readLine() ?: ""

    val result = calculateRPN(input)

    result?.let {
        println("Результат: $it")
    } ?: println("Ошибка в вычислении.")
}
