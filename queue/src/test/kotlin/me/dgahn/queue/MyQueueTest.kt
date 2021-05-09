package me.dgahn.queue

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyQueueTest {

    @Test
    fun `add()를 통해서 큐에 데이터를 넣을 수 있다`() {
        val queue = MyQueue<Int>()
        queue.add(1)
        queue.add(2)

        assertThat(queue.size).isEqualTo(2)
    }

    @Test
    fun `poll()을 통해서 큐의 데이터를 가져올 수 있다`() {
        val queue = MyQueue<Int>()
        queue.add(1)
        queue.add(2)

        assertThat(queue.poll()).isEqualTo(1)
        assertThat(queue.size).isEqualTo(1)
    }

    @Test
    fun `queue에 데이터가 없는 경우에는 null을 반환한다`() {
        val queue = MyQueue<Int>()

        assertThat(queue.poll()).isNull()
    }

}
