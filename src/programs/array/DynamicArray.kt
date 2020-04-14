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

    val queryMap = emptyMap<Int, List<Int>>().toMutableMap()

    var result = emptyArray<Int>().toMutableList()
    for (i in 0 until n) {
        queryMap[i] = emptyList<Int>().toMutableList()
    }
//    queryMap.forEach { (key, value) -> println("$key = $value") }

    // loop through the queries
    for (query in queries) {
//        println("query type ${query[0]}")
        // check for the query type in the zeroth element of the query
        when (query[0]) {
            // query type 1
            1 -> {
                val seq = getSequence(query, lastAnswer, n)
//                println("query type 1: seq: $seq")

                val temp = queryMap.get(seq)!!.toMutableList()
//                println("seq size before adding '${query[2]}' is ${temp.size}")
                temp.add(query[2])
//                println("seq size after adding ${temp.size}")
                queryMap.put(seq, temp)
//                for (j in temp) {
//                    print("$j ")
//                }
//                queryMap.forEach { (key, value) -> println("$key = $value") }
            }
            // query type 2
            2 -> {
                val seq = getSequence(query, lastAnswer, n)
//                println("query type 2: seq: $seq")
                val temp = queryMap[seq]!!
                val index = query[2] % temp.size
                lastAnswer = temp[index]

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