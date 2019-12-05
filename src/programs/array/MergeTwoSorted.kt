package programs.array

class MergeTwoSorted {


    companion object {
        // Merge arr1[0..n1-1] and arr2[0..n2-1]
        // into arr3[0..n1+n2-1]
        fun mergeArrays(arr1: IntArray, arr2: IntArray, n1: Int,
                        n2: Int, arr3: IntArray) {
            var i = 0
            var j = 0
            var k = 0
            // Traverse both array
            while (i < n1 && j < n2) { // Check if current element of first
// array is smaller than current element
// of second array. If yes, store first
// array element and increment first array
// index. Otherwise do same with second array
                if (arr1[i] < arr2[j]) arr3[k++] = arr1[i++] else arr3[k++] = arr2[j++]
            }
            // Store remaining elements of first array
            while (i < n1) arr3[k++] = arr1[i++]
            // Store remaining elements of second array
            while (j < n2) arr3[k++] = arr2[j++]
        }

    }

}

fun main() {
    val arr1: IntArray = intArrayOf(1, 2, 3, 5, 7)
    val n1 = arr1.size

    val arr2 = intArrayOf(2, 4, 6, 8)
    val n2 = arr2.size

    val arr3 = IntArray(n1 + n2)

    MergeTwoSorted.mergeArrays(arr1, arr2, n1, n2, arr3)

    println("Array after merging")
    for (i in 0 until (n1 + n2)) {
        print("${arr3[i]}\t")
    }
}