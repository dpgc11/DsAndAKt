package programs.array

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var hourglassSums = emptyList<Int>().toMutableList()

//    [0][0] [0][1] [0][2]    [0][1] [0][2] [0][3]    [0][2] [0][3] [0][4]    [0][3] [0][4] [0][5]
//            [1][1]                  [1][2]                  [1][3]                  [1][4]
//    [2][0] [2][1] [2][2]    [2][1] [2][2] [2][3]    [2][2] [2][3] [2][4]    [2][3] [2][4] [2][5]
//
//    [1][0] [1][1] [1][2]    [1][1] [1][2] [1][3]    [1][2] [1][3] [1][4]    [1][3] [1][4] [1][5]
//            [2][1]                  [2][2]                  [2][3]                  [2][4]
//    [3][0] [3][1] [3][2]    [3][1] [3][2] [3][3]    [3][3] [3][3] [3][4]    [3][3] [3][4] [3][5]
//
//    [2][0] [2][1] [2][2]    [2][1] [2][2] [2][3]    [2][2] [2][3] [2][4]    [2][3] [2][4] [2][5]
//            [3][1]                  [3][2]                  [3][3]                  [3][4]
//    [4][0] [4][1] [4][2]    [4][1] [4][2] [4][3]    [4][2] [4][3] [4][4]    [4][3] [4][4] [4][5]
//
//    [3][0] [3][1] [3][2]    [3][1] [3][2] [3][3]    [3][2] [3][3] [3][4]    [3][3] [3][4] [3][5]
//            [4][1]                  [4][2]                  [4][3]                  [4][4]
//    [5][0] [5][1] [5][2]    [5][1] [5][2] [5][3]    [5][2] [5][3] [5][4]    [5][3] [5][4] [5][5]

    // determine the current hourglass and
    // sum up the current hourglass
    var sum = 0
    for (i in 0..3) {
        for (j in 0..3) {
            sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
            // add the sum to the sumArrayList
            hourglassSums.add(sum)
        }
    }
    // return the max value from the hourglassSumArrayList
    return hourglassSums.max()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}