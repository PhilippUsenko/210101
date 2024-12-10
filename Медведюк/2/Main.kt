import kotlin.random.Random

fun transposeMatrix(matrix: Array<Array<Int>>): Array<Array<Int>> {

    val size = matrix.size
    val transposed = Array(size) {
        Array(size) {0}
    }
    for(i in matrix.indices) {
        for(j in matrix[i].indices) {
            transposed[j][i] = matrix[i][j]
        }
    }
    return transposed
}

fun printMatrix(matrix: Array<Array<Int>>) {
    for(row in matrix) {
        println(row.joinToString(" "))
    }
}


fun main() {
    val size = 5
    val range = 0..100

    val matrix = Array(size) {
        Array(size) {
            Random.nextInt(range.first, range.last)
        }
    }

    println("Исходная матрица: ")
    printMatrix(matrix)

    val transposedMatrix = transposeMatrix(matrix)

    println("Транспонированная матрица: ")
    printMatrix(transposedMatrix)
}