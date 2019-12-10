package programs.array

/*
Returns true if there is a subarray of arr[] with a sum equal to
'sum' otherwise returns false. Also, prints the result
 */
fun subarraySumBruteForce(arr: IntArray, n: Int, sum: Int): Boolean {
    var result = false
    var currentSum = -1

    // Pick a starting point
    for (i in 0 until n) {
        currentSum = arr[i]

        // try all subarrays starting with 'i'
        for (j in i + 1..n) {

            if (currentSum == sum) {
                val p = j - 1
                println("Sum found between indexes $i and $p")
                result = true
                return result
            }

            if (currentSum > sum || j == n) {
                break
            }

            currentSum = currentSum + arr[j]
        }
    }

    println("No subarray found")
    return result
}

fun main() {
    val arr = intArrayOf(15, 2, 4, 8, 9, 5, 10, 23)
    val n = arr.size
    val sum = 23
    subarraySumBruteForce(arr, n, sum)
}
