package programs.linkedList

import java.util.*


// Complete the getNode function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     data: Int
 *     next: SinglyLinkedListNode
 * }
 *
 */
fun getNode(_llist: SinglyLinkedListNode?, positionFromTail: Int): Int {
    var result = -1
    var llist = _llist

    /**
     * 2 pointer method START
     */
    var main_ptr: SinglyLinkedListNode? = _llist
    var ref_ptr: SinglyLinkedListNode? = _llist

    var count = 0
    if (_llist != null) {
        while (count <= positionFromTail) {
//            if (ref_ptr == null) {
//                return
//            }
            ref_ptr = ref_ptr?.next
            count++
        }
        while (ref_ptr != null) {
            main_ptr = main_ptr!!.next
            ref_ptr = ref_ptr.next
        }
        if (main_ptr != null)
            result = main_ptr.data
    }

    /**
     * END
     */
    /**
     * Length of LL start
     */
//    // 0 1 2 3 4    indexes
//    // 5 4 3 2 1    values
//    // size -  (positionFromTail + 1) from the start will give the item at positionFromTail when size is known
//    // 5 - (3 + 1) = 1
//    var count = 0
//    // find the size of the LL
//    while (llist != null) {
//        llist = llist.next
//        count++
//    }
//    llist = _llist
//    // deduce the positionFromStart using the formula
//    val positionFromStart = count - (positionFromTail + 1)
//    println("positionFromStart: $positionFromStart")
//    // get the value at positionFromStart
//    for (i in 0 until positionFromStart) {
//        llist = llist?.next
//    }
//    // assign the value to result
//    if (llist != null) {
//        result = llist.data
//    }
    /**
     * END
     */

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val tests = scan.nextLine().trim().toInt()

    for (testsItr in 1..tests) {
        val llistCount = scan.nextLine().trim().toInt()
        val llist = SinglyLinkedList()

        for (i in 0 until llistCount) {
            val llist_item = scan.nextLine().trim().toInt()
            llist.insertNode(llist_item)
        }

        val position = scan.nextLine().trim().toInt()

        val result = getNode(llist.head, position)

        println(result)
    }
}