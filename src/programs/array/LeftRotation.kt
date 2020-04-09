package programs.array

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    leftRotate(a, d)
}

fun leftRotate(_a: Array<Int>, _d: Int) {
    val a = _a
    val d = _d
    val iterations = d % a.size
    println("iterations: $iterations")
    for (j in 0 until iterations) {
        val temp = a[a.size - 1]
        a[a.size - 1] = a[0]

        for (i in 0 until a.size - 1) {
            a[i] = a[i + 1]
        }

        a[a.size - 2] = temp
        println("while loop: j: $j")
        a.forEach { print("$it  ") }
        println()
    }

    print(a.joinToString(" "))
}

