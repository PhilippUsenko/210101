import kotlin.math.sqrt

fun main() {
    println("Квадратное уравнение выглядит - ax^2 + bx + c = 0: ")
    var a: Double? = null
    var b: Double? = null
    var c: Double? = null
    println("Введите значение а")
    while (a == null){
        a = readln().toDoubleOrNull()
        if(a == null){
            println("Введите число: ")
        }else if (a == 0.0){
            println("Значение а не может равняться 0")
        }
    }
    println("Введите значение b")
    while (b == null){
        b = readln().toDoubleOrNull()
        if(b == null){
            println("Введите число: ")
        }
    }
    println("Введите значение c")
    while (c == null){
        c = readln().toDoubleOrNull()
        if(c == null){
            println("Введите число: ")
        }
    }
    val discr = b * b - 4 * a * c

    if (discr >= 0){
        val x1 = (-b + sqrt(discr)) / (2 * a)
        val x2 = (-b - sqrt(discr)) / (2 * a)
        println("Корни уранения х1 = $x1, х2 = $x2")
        var start: Int? = null
        var end: Int? = null
        while (start == null || end == null || start > end){
            println("Введите диапазон целых решенеий уравнения\nот: ")
            start = readln().toIntOrNull()
            println("до: ")
            end = readln().toIntOrNull()
            if(start == null || end == null || start > end){
                println("Неккоректный ввод")
            }
        }
        for (x in start..end){
            val  solution = a * x * x + b * x + c
            if (solution == 0.0){
                println("Целое решение: $x")
            }
        }
    } else{
        val part1 = -b / (2 * a)
        val part2 = sqrt(-discr) / (2 * a)
        println("Уравнение имеет комплексные решения: ")
        println("x1 = $part1 + ${part2}i")
        println("x1 = $part1 - ${part2}i")
    }
}