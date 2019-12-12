package programs.string

fun main() {
    val s = "i like this program very much".split(" ")
    var ans = ""

    for (i in s.size - 1 downTo 0) {
        ans += s[i] + " "
    }

    println("Reversed String: ")
    println(ans.substring(0, ans.length - 1))
}