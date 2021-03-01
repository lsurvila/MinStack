import java.util.*

class MinStack<T : Comparable<T>> {

    // first - element, second - minElement of stack when element was added
    private val data: Stack<Pair<T, T>> = Stack()

    fun push(element: T) {
        val minElement: T = if (data.isEmpty() || element < min())
            element
        else
            data.peek().second
        data.push(Pair(element, minElement))
    }

    fun min(): T = data.peek().second

    fun pop() {
        data.pop()
    }

    fun top(): T = data.peek().first
}