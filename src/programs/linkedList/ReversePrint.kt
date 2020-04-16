package programs.linkedList

import java.util.*

class SinglyLinkedListNode(nodeData: Int) {
    var data: Int = nodeData
    var next: SinglyLinkedListNode? = null
}

class SinglyLinkedList {
    var head: SinglyLinkedListNode?
    var tail: SinglyLinkedListNode?

    init {
        head = null
        tail = null
    }

    fun insertNode(nodeData: Int) {
        val node = SinglyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }

        tail = node
    }

}

fun printSinglyLinkedList(head: SinglyLinkedListNode?, sep: String) {
    var node = head

    while (node != null) {
        print(node.data)
        node = node.next

        if (node != null) {
            print(sep)
        }
    }
}

// Complete the reversePrint function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     data: Int
 *     next: SinglyLinkedListNode
 * }
 *
 */
fun reversePrint(_llist: SinglyLinkedListNode?) {

    val llist = _llist
    var current = llist
    var prev: SinglyLinkedListNode? = null
    var next: SinglyLinkedListNode? = null

    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }

    while (prev != null) {
        println("${prev.data}")
        prev = prev.next
    }
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

        reversePrint(llist.head)
    }
}
