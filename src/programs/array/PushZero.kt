package programs.array

class PushZero {

    companion object {

        // function which pushes all zeroes to end of an array
        fun pushZeroesToEnd(arr: IntArray, n: Int) {

            // count of non-zero elements
            var count = 0

            // Traverse the array. IF element encountered is
            // non-zero, then replace the element at index 'count'
            // with this element
            for (i in 0 until n) {
                if (arr[i] != 0) {
                    // here count in incremented
                    arr[count++] = arr[i]
                }
            }

            // Now all non-zero elements have been shifted to
            // front and 'count' is set as index of first 0.
            // Make all elements 0 from count to end.
            while (count < n) {
                arr[count++] = 0
            }

        }
    }
}

fun main() {
    val arr = intArrayOf(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9)
    val n = arr.size
    PushZero.pushZeroesToEnd(arr, n)
    println("Array after pushing zeroes to the back: ")
    for (i in 0 until n) {
        print("${arr[i]}\t")
    }
}