package search

fun main() {
    val arr = intArrayOf(2, 3, 4, 10, 40)
    val x = 10
    val result: Int = binarySearch(arr, x)
    if (result == -1) println("Element not present") else println("Element found at "
            + "index " + result)
}

fun binarySearch(arr: IntArray, x: Int): Int {
    var result = -1
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        var mid = left + (right - 1) / 2

        // Check if x is +nt at mid
        if (arr.get(mid) == x) {
            return mid
        }

        // if x is greater, ignore left half
        if (arr.get(mid) < x) {
            left = mid + 1
        }

        // If x is smaller, ignore right half
        else
            right = mid - 1
    }

    // if we reach here, then element was not +nt
    return result
}