fun main(args: Array<String>) {
    val minStack = MinStack<Int>()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.min())
    minStack.pop()
    println(minStack.top())
    println(minStack.min())
}