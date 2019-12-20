package programs.array

import java.util.*

// Complete the reverseArray function below.
fun reverseArray(a: Array<Int>): Array<Int> {

    val result = Array<Int>(a.size) { 0 }
    var initialFlag = 0
    for (i in a.size - 1 downTo 0) {
        result[initialFlag] = a[i]
        initialFlag += 1
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arrCount = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}
