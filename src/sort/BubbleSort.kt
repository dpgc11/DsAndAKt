package sort

fun bubbleSort(arr: IntArray) {
    var temp: Int
    val n = arr.size
    var swapped: Boolean

    for (i in 0 until n - 1) {
        swapped = false
        for (j in 0 until n - i - 1) {
            if (arr.get(j) > arr.get(j + 1)) { // swap arr[j] and arr[j+1]
                temp = arr.get(j)
                arr.set(j, arr.get(j + 1))
                arr.set(j + 1, temp)
                swapped = true
            }
        }
        // If no two elements were
        // swapped by inner loop, then break
        if (swapped == false) break
    }
}

/* Prints the array */
fun printArray(arr: IntArray) {
    for (i in 0 until arr.size) {
        print("${arr.get(i)} \t")
    }
    println()
}

fun main() {
    val arr: IntArray = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    println("Initial array")
    printArray(arr)
    bubbleSort(arr)
    println("Sorted array")
    printArray(arr)
}






