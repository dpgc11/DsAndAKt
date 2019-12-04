package ds

class StackAsArray {

    companion object {
        const val MAX = 1000
    }

    var top: Int
    var arr = IntArray(MAX)

    fun isEmpty(): Boolean {
        return top < 0
    }

    fun push(x: Int): Boolean {
        if (top >= MAX - 1) {
            println("Stack Overflow")
            return false
        } else {
            arr.set(++top, x)
            println("$x pushed into stack")
            return true
        }
    }

    fun pop(): Int {
        if (top < 0) {
            println("Stack Underflow")
            return 0
        } else {
            val x = arr.get(top--)
            return x
        }
    }

    fun peek(): Int {
        if (top < 0) {
            println("Stack Underflow")
            return 0
        } else {
            val x = arr.get(top)
            return x
        }
    }


    init {
        top = -1
    }


}

fun main() {
    val s = StackAsArray()
    s.push(10)
    s.push(20)
    s.push(30)
    println("${s.pop()} Popped from stack")
}