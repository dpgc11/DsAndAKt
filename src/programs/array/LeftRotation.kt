package programs.array

import java.util.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    leftRotate(a, d)
}

fun leftRotate(_a: Array<Int>, _d: Int) {
    val a = _a.toMutableList()
    val d = _d
    val iterations = d % a.size

    val tempArray1 = a.subList(iterations, a.size)
    val tempArray = a.subList(0, iterations)

    tempArray1.addAll(tempArray)

    print(tempArray1.joinToString(" "))
}

