fun generateMagicSquare(n: Int): Array<IntArray> {
    if (n % 2 == 0) {
        throw IllegalArgumentException("Магический квадрат можно создать только для нечетного размера.")
    }

    val magicSquare = Array(n) { IntArray(n) }
    var number = 1
    var row = 0
    var col = n / 2

    while (number <= n * n) {
        magicSquare[row][col] = number
        number++
        // одна строка вверх и одна колонка вправо
        val newRow = (row - 1 + n) % n
        val newCol = (col + 1) % n

        if (magicSquare[newRow][newCol] != 0) {
            row = (row + 1) % n
        } else {
            row = newRow
            col = newCol
        }
    }

    return magicSquare
}

fun printMagicSquare(square: Array<IntArray>) {
    for (row in square) {
        for (value in row) {
            print("$value\t")
        }
        println()
    }
}

fun main() {
    while (true) {
        println("Введите размер магического квадрата (нечетное число): ")
        val n = readLine()?.toIntOrNull()

        if (n == null || n % 2 == 0) {
            println("Размер магического квадрата должен быть нечетным числом.")
        } else if (n == 1){
            println("Нельзя построить матрицу для 1")
        } else {
            val magicSquare = generateMagicSquare(n)
            println("Магический квадрат размером $n x $n:")
            printMagicSquare(magicSquare)
        }

        println("Хотите создать новый магический квадрат? (да/нет): ")
        val answer = readLine()?.lowercase()

        if (answer != "да") {
            println("Программа завершена.")
            break
        }
    }
}
