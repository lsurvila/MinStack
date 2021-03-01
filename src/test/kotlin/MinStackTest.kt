import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*
import kotlin.test.assertEquals

class MinStackTest {

    @Nested
    inner class Push {

        @Test
        fun `push to empty stack`() {
            val stack = MinStack<Int>()

            stack.push(10)

            assertEquals(10, stack.top())
            assertEquals(10, stack.min())
        }

        @Test
        fun `push to existing stack`() {
            val stack = MinStack<Int>()
            stack.push(10)

            stack.push(5)

            assertEquals(5, stack.top())
            assertEquals(5, stack.min())
        }

        @Test
        fun `push bigger element`() {
            val stack = MinStack<Int>()
            stack.push(10)
            stack.push(5)

            stack.push(7)

            assertEquals(7, stack.top())
            assertEquals(5, stack.min())
        }
    }

    @Nested
    inner class Min {

        @Test
        fun `min throws exception when stack is empty`() {
            val stack = MinStack<Int>()

            assertThrows<EmptyStackException> { stack.min() }
        }

        @Test
        fun `min throws exception when stack is emptied`() {
            val stack = MinStack<Int>()
            stack.push(10)
            stack.pop()

            assertThrows<EmptyStackException> { stack.min() }
        }
    }

    @Nested
    inner class Pop {
        @Test
        fun `pop throws exception when stack is empty`() {
            val stack = MinStack<Int>()

            assertThrows<EmptyStackException> { stack.pop() }
        }

        @Test
        fun `pop throws exception when stack is emptied`() {
            val stack = MinStack<Int>()
            stack.push(10)
            stack.pop()

            assertThrows<EmptyStackException> { stack.pop() }
        }

        @Test
        fun `pop bigger element`() {
            val stack = MinStack<Int>()
            stack.push(5)
            stack.push(10)
            stack.push(15)

            stack.pop()

            assertEquals(10, stack.top())
            assertEquals(5, stack.min())
        }

        @Test
        fun `pop min element`() {
            val stack = MinStack<Int>()
            stack.push(5)
            stack.push(10)
            stack.push(3)
            assertEquals(3, stack.top())
            assertEquals(3, stack.min())

            stack.pop()

            assertEquals(10, stack.top())
            assertEquals(5, stack.min())
        }
    }
}