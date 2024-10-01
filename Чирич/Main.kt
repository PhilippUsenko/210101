import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод базы системы счисления
    print("Введите базу системы счисления (от 2 до 36): ")
    val base = scanner.nextInt()
    if (base !in 2..36) {
        println("Ошибка: база должна быть в диапазоне от 2 до 36.")
        return
    }

    // Ввод числа в указанной системе счисления
    print("Введите число в системе счисления с базой $base: ")
    val numberStr = scanner.next().toUpperCase()

        // Конвертация числа в десятичную систему
    val decimalValue = numberStr.toInt(base)
    println("$numberStr в десятичной системе = $decimalValue")

        // Конвертация обратно в указанную систему счисления
    if (decimalValue == 0) {
        println("0 в системе счисления с базой $base = 0")
    } else {
        val digits = StringBuilder()
        var n = decimalValue
        while (n > 0) {
            val remainder = n % base
            val char = if (remainder < 10) {
                '0' + remainder
            } else {
                'A' + (remainder - 10)
            }
            digits.append(char)
            n /= base
        }
        val convertedStr = digits.reverse().toString()
        println("$decimalValue в системе счисления с базой $base = $convertedStr")
    }

}
