package programs.array

import kotlin.math.abs

// This class will store the result
data class Pair(var i: Int, var j: Int)

// ar1[0..m-1] and ar2[0..n-1] are two given sorted
// arrays/ and x is given number. This function prints
// the pair from both arrays such that the sum of the
// pair is closest to x.
// Brute Force Approach
fun printClosest(ar1: IntArray, ar2: IntArray, m: Int, n: Int, x: Int) {
    // init the result
    val pair = Pair(ar1[0], ar2[0])
    var difference = Int.MAX_VALUE

    for (i in 0 until  ar1.size) {
        for (j in 0 until ar2.size) {
            val tempDifference = abs(x - (ar1[i] + ar2[j]))
            println("Temp difference between ${ar1[i]} and ${ar2[j]} is $tempDifference")
            if (tempDifference < difference) {
                pair.i = ar1[i]
                pair.j = ar2[j]
                difference = tempDifference
            }
        }
    }
    // Print the result
    println("The closest pair are: ${pair.i} and ${pair.j}")
}

fun main(args: Array<String>) {
    val ar1 = intArrayOf(1, 4, 5, 7)
    val ar2 = intArrayOf(10, 20, 30, 40)
    val m = ar1.size
    val n = ar2.size
    val x = 38
    printClosest(ar1, ar2, m, n, x)
}