package programs.linkedList

import java.util.*

// Complete the reverse function below.

/*
 * For your reference:
 *
 * DoublyLinkedListNode {
 *     data: Int
 *     next: DoublyLinkedListNode
 *     prev: DoublyLinkedListNode
 * }
 *
 */
fun reverse(_llist: DoublyLinkedListNode?): DoublyLinkedListNode? {
//    print("original: ")
//    printDoublyLinkedList(_llist, " ")
    var next: DoublyLinkedListNode? = null
    var prev: DoublyLinkedListNode? = null
    var current: DoublyLinkedListNode? = null
    var llist = _llist

    // 1 <-> 2 <-> 3 <-> 4 -> NULL
    // 4 <-> 3 <-> 2 <-> 1 -> NULL
    while (llist != null) {
        current = llist
        next = current.next
        prev = current.prev

//        println("prev: ${prev?.data}\tcurrent: ${current.data}\tnext: ${next?.data}")

//        current.next = prev
//        current.prev = next

        llist = llist.next

        current.next = prev
        current.prev = next

    }
//    println()
//    println("after while llist:${llist?.data}\tprev: ${prev?.data}\tcurrent: ${current?.data}\tnext: ${next?.data}")
//    print("current: ")
//    printDoublyLinkedList(current, " ")
//    println()
//
//    println()

    return current
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val llistCount = scan.nextLine().trim().toInt()
        val llist = DoublyLinkedList()

        for (i in 0 until llistCount) {
            val llist_item = scan.nextLine().trim().toInt()
            llist.insertNode(llist_item)
        }

        val llist1 = reverse(llist.head)

        printDoublyLinkedList(llist1, " ")
//        println()
    }
}
