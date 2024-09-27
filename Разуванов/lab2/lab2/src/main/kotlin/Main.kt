fun main() {
    while (true) {
        println("Введите размер магического квадрата (размер должен быть >= 3):")
        val size = readLine()?.toIntOrNull() ?: return

        if (size < 3) {
            println("Размер магического квадрата должен быть больше 2.")
            continue
        }

        val magicSquare = if (size % 2 == 1) {
            generateOddMagicSquare(size)
        } else if (size % 4 == 0) {
            generateDoublyEvenMagicSquare(size)
        } else {
            generateSinglyEvenMagicSquare(size)
        }

        printMagicSquare(magicSquare)

        println("Желаете продолжить? (д/н)")
        if (readlnOrNull() != "д") break
    }
}

fun generateOddMagicSquare(size: Int): Array<IntArray> {
    val magicSquare = Array(size) { IntArray(size) }
    var number = 1
    var i = 0
    var j = size / 2

    while (number <= size * size) {
        magicSquare[i][j] = number
        number++
        i--
        j++

        if (number % size == 1) {
            i += 2
            j--
        }

        if (i < 0) {
            i = size - 1
        }

        if (j == size) {
            j = 0
        }
    }

    return magicSquare
}

fun generateDoublyEvenMagicSquare(size: Int): Array<IntArray> {
    val magicSquare = Array(size) { IntArray(size) }
    var number = 1
    val n = size

    for (i in 0 until n) {
        for (j in 0 until n) {
            magicSquare[i][j] = number++
        }
    }

    for (i in 0 until n / 4) {
        for (j in 0 until n / 4) {
            magicSquare[i][j] = n * n + 1 - magicSquare[i][j]
            magicSquare[i][n - j - 1] = n * n + 1 - magicSquare[i][n - j - 1]
            magicSquare[n - i - 1][j] = n * n + 1 - magicSquare[n - i - 1][j]
            magicSquare[n - i - 1][n - j - 1] = n * n + 1 - magicSquare[n - i - 1][n - j - 1]
        }
    }

    return magicSquare
}

fun generateSinglyEvenMagicSquare(size: Int): Array<IntArray> {
    val subSize = size / 2
    val subMagicSquare = generateOddMagicSquare(subSize)
    val magicSquare = Array(size) { IntArray(size) }

    for (i in 0 until subSize) {
        for (j in 0 until subSize) {
            magicSquare[i][j] = subMagicSquare[i][j]
            magicSquare[i + subSize][j] = subMagicSquare[i][j] + 2 * subSize * subSize
            magicSquare[i][j + subSize] = subMagicSquare[i][j] + 3 * subSize * subSize
            magicSquare[i + subSize][j + subSize] = subMagicSquare[i][j] + subSize * subSize
        }
    }

    val colChange = subSize / 2
    for (i in 0 until subSize) {
        for (j in 0 until colChange) {
            val temp = magicSquare[i][j]
            magicSquare[i][j] = magicSquare[i + subSize][j]
            magicSquare[i + subSize][j] = temp
        }
    }

    for (i in 0 until subSize) {
        for (j in 0 until subSize - 1) {
            val temp = magicSquare[i][j + subSize + 1]
            magicSquare[i][j + subSize + 1] = magicSquare[i + subSize][j + subSize + 1]
            magicSquare[i + subSize][j + subSize + 1] = temp
        }
    }

    return magicSquare
}

fun printMagicSquare(magicSquare: Array<IntArray>) {
    val size = magicSquare.size
    for (i in 0 until size) {
        for (j in 0 until size) {
            print("${magicSquare[i][j]}\t")
        }
        println()
    }
}
