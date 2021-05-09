package me.dgahn.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyStackTest {

    @Test
    fun `스택의 값을 저장할 수 있다`() {
        val stack = MyStack<Int>()
        val result = stack.push(100)
        assertThat(result).isEqualTo(100)
    }

    @Test
    fun `스택의 값을 가져오면 마지막에 넣은 값을 가져온다`() {
        val stack = MyStack<Int>()
        stack.push(100)
        stack.push(50)
        assertThat(stack.pop()).isEqualTo(50)
    }

    @Test
    fun `스택의 값이 없는데 pop() 하면 null을 반환한다`() {
        val stack = MyStack<Int>()
        assertThat(stack.pop()).isNull()
    }

}
