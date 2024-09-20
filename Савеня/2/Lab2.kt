fun bubbleSort(arr: IntArray) {

    var n = arr.size
    var swapped: Boolean

    do {
        swapped = false
        for (i in 1 until n) {
            if (arr[i - 1] > arr[i]) {
                val temp = arr[i - 1]
                arr[i - 1] = arr[i]
                arr[i] = temp

                swapped = true
            }
        }
        n--
    } while (swapped)
}

fun main() {

    println("Enter Numbers to Be Sorted, Separated by Space:")

    val input = readLine()

    val arr = input?.split(" ")?.map { it.toInt() }?.toIntArray()

    if (arr != null) {
        println("Original Array: ${arr.joinToString()}")

        bubbleSort(arr)

        println("Sorted Array: ${arr.joinToString()}")
    }
    else {
        println("Invalid Input!")
    }
}