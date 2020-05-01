package programs.linkedList

import java.util.*

class DoublyLinkedListNode(nodeData: Int) {
    var data: Int
    var next: DoublyLinkedListNode?
    var prev: DoublyLinkedListNode?

    init {
        data = nodeData
        next = null
        prev = null
    }
}

class DoublyLinkedList {
    var head: DoublyLinkedListNode?
    var tail: DoublyLinkedListNode?

    init {
        head = null
        tail = null
    }

    fun insertNode(nodeData: Int) {
        var node = DoublyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
            node.prev = tail
        }

        tail = node
    }

}

fun printDoublyLinkedList(head: DoublyLinkedListNode?, sep: String) {
    var node = head

    while (node != null) {
        print(node.data)
        node = node.next

        if (node != null) {
            print(sep)
        }
    }
}

// Complete the sortedInsert function below.

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
fun sortedInsert(llist: DoublyLinkedListNode?, data: Int): DoublyLinkedListNode? {

    var node = DoublyLinkedListNode(data)

    // 1 2 3
    // data = 4
    if (llist != null) {
        var head = llist
        var temp = llist
        var prev: DoublyLinkedListNode? = null
        var next: DoublyLinkedListNode? = null

        while (temp != null) {
            prev = temp.prev
            next = temp.next
//            println("temp: ${temp?.data}\tprev: ${prev?.data}\tnext: ${next?.data}")
            if (node.data <= temp.data) {
                node.next = temp
                if (prev != null) {
                    prev.next = node
                } else {
                    temp.prev = node
                }
                node.prev = prev
                break
            }

            if (next != null) {
                temp = next
            } else {
                if (temp != null) {
                    temp.next = node
                }
                node.prev = temp
                break
            }
        }
//        println("outside while temp: ${temp?.data}\tprev: ${prev?.data}\tnext: ${next?.data}")
        if (node.data > head.data)
            node = head
    }


    return node

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

        val data = scan.nextLine().trim().toInt()

        val llist1 = sortedInsert(llist.head, data)

        printDoublyLinkedList(llist1, " ")
    }
}
