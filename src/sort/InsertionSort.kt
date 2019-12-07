package sort

class InsertionSort {

    companion object {
        fun printArray(arr: IntArray) {
            for (i in 0 until arr.size) {
                print("${arr[i]}\t")
            }
            println()
        }
    }

    fun sort(arr: IntArray) {

        for (i in 1 until arr.size) {
            val key = arr[i]
            var j = i - 1

            /*
                Move elements of arr[0..i-1], that are
                greater than key, to one position ahead
                of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j -= 1
            }

            arr[j + 1] = key
        }
    }

}

fun main() {
    val arr = intArrayOf(12, 11, 13, 5, 6)

    val ob = InsertionSort()
    ob.sort(arr)

    InsertionSort.printArray(arr)
}

