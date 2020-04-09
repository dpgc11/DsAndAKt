package programs.array

/*
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    // Write your code here
    // init values
    var lastAnswer = 0
    var S0 = emptyList<Int>().toMutableList()
    var S1 = emptyList<Int>().toMutableList()
    var result = emptyArray<Int>().toMutableList()

    // loop through the queries
    for (query in queries) {
        // check for the query type in the zeroth element of the query
        when (query[0]) {
            // query type 1
            1 -> {
                // get the sequence number
                when (getSequence(query, lastAnswer, n)) {
                    0 -> {
                        S0.add(query[2])
                    }
                    1 -> {
                        S1.add(query[2])
                    }
                }
            }
            // query type 2
            2 -> {
                // get the sequence number
                when (getSequence(query, lastAnswer, n)) {
                    0 -> {
                        lastAnswer = S0[query[2]]
                    }
                    1 -> {
                        lastAnswer = S1[query[2]]
                    }
                }
                result.add(lastAnswer)
            }
        }
    }
    return result.toTypedArray()
}

/**
 * Returns the sequence number
 */
private fun getSequence(query: Array<Int>, lastAnswer: Int, n: Int) =
        (query[1] xor lastAnswer) % n


fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val q = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(3, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = dynamicArray(n, queries)

    println(result.joinToString("\n"))
}