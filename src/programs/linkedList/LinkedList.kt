package programs.linkedList

class Node(value: Int) {
    var value: Int = value
    var next: Node? = null
    var previous: Node? = null
}

class LinkedList {

    var head: Node? = null

    // reverse the linked list
    fun reverse(_n: Node): Node {
        var node: Node = _n
        var prev: Node? = null
        var current: Node = node
        var next: Node?

        while (current != null) {
            next = current.next
            print("while loop next ${next!!.value}")
            current.next = prev!!
            prev = current
            current = next
        }

        node = prev!!
        return node
    }

    // prints content of double linked list
    fun printList(n: Node?) {
        var node = n
        while (node != null) {
            print("${node.value} -> ")
            node = node.next
        }
        print("NULL")
        println()
    }
}

fun main() {
    val list = LinkedList()
    list.head = Node(85)
    list.head!!.next = Node(15)
    list.head!!.next!!.next = Node(4)
    list.head!!.next!!.next!!.next = Node(20)

    println("Given Linked list")
    list.printList(list.head)
    list.head = list.reverse(list.head!!)

    println()
    println("Reversed Linked list")
    list.printList(list.head)

}