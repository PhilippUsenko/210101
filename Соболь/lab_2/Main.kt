import java.util.Scanner

fun findSubarraysWithGivenSum(arr: IntArray, targetSum: Int) {
    val n = arr.size
    var found = false

    // Перебираем все возможные начальные индексы подмассивов
    for (start in 0 until n) {
        var currentSum = 0

        // Перебираем все возможные конечные индексы подмассивов
        for (end in start until n) {
            currentSum += arr[end]

            // Если текущая сумма равна целевому значению, выводим индексы и подмассив
            if (currentSum == targetSum) {
                found = true
                print("Подмассив с суммой $targetSum найден с индексами от $start до $end: ")
                for (i in start..end) {
                    print("${arr[i]} ")
                }
                println()
            }
        }
    }

    // Если не найдено ни одного подмассива
    if (!found) {
        println("Подмассивов с суммой $targetSum не найдено")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод массива
    println("Введите количество элементов в массиве:")
    val size = scanner.nextInt()
    val arr = IntArray(size)
    println("Введите элементы массива:")
    for (i in 0 until size) {
        arr[i] = scanner.nextInt()
    }

    // Ввод целевой суммы
    println("Введите целевую сумму:")
    val targetSum = scanner.nextInt()

    // Поиск подмассивов с заданной суммой
    findSubarraysWithGivenSum(arr, targetSum)
}
