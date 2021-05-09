package me.dgahn.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class StackTest {

    @Test
    fun `Stack에 값을 넣을 수 있다`() {
        val stack = Stack<Int>()
        val result = stack.push(100)

        assertThat(result).isEqualTo(100)
    }

    @Test
    fun `Stack의 값을 꺼낼 수 있다`() {
        val stack = Stack<Int>()
        stack.push(100)
        stack.push(50)

        assertThat(stack.pop()).isEqualTo(50)
    }

}
