/*12.	Определение наибольшего общего делителя и наименьшего общего кратного:
 Напишите программу, которая вычисляет НОД и НОК для двух введенных чисел.
 Реализуйте алгоритм Евклида для поиска НОД.
 */
import java.util.*

fun gcd(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}

fun lcm(a: Int, b: Int): Int {
    return (a * b) / gcd(a, b)
}

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        try {
            print("Введите первое число (или 'exit' для выхода): ")
            val input1 = scanner.next()

            if (input1.equals("exit", ignoreCase = true)) {
                println("Программа завершена.")
                break
            }

            print("Введите второе число: ")
            val input2 = scanner.next()

            val num1 = input1.toInt()
            val num2 = input2.toInt()

            if (num1 == 0 || num2 == 0) {
                println("Ошибка: НОД и НОК не определены для чисел, содержащих 0.")
                continue
            }

            val nod =  gcd(num1, num2)
            val nok = lcm(num1, num2)

            println("Наибольший общий делитель (НОД) для $num1 и $num2: $nod")
            println("Наименьшее общее кратное (НОК) для $num1 и $num2: $nok")
        } catch (e: InputMismatchException) {
            println("Ошибка: Введите корректное целое число.")
            scanner.nextLine()
        } catch (e: NumberFormatException) {
            println("Ошибка: Ввод должен быть числом.")
        } catch (e: Exception) {
            println("Произошла непредвиденная ошибка: ${e.message}")
        }
    }
}
