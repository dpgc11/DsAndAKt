package programs.linkedList

import java.util.*


// Complete the removeDuplicates function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     data: Int
 *     next: SinglyLinkedListNode
 * }
 *
 */
fun removeDuplicates(head: SinglyLinkedListNode?): SinglyLinkedListNode? {

    if (head == null) return null
    var nextItem: SinglyLinkedListNode? = head.next
    while (nextItem != null && head.data === nextItem.data) {
        nextItem = nextItem.next
    }
    head.next = removeDuplicates(nextItem)
    return head

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val llistCount = scan.nextLine().trim().toInt()
        val llist = SinglyLinkedList()

        for (i in 0 until llistCount) {
            val llist_item = scan.nextLine().trim().toInt()
            llist.insertNode(llist_item)
        }

        val llist1 = removeDuplicates(llist.head)

        printSinglyLinkedList(llist1, " ")
    }
}
