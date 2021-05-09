package me.dgahn.queue

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class QueueTest {

    @Test
    fun `큐에 데이터를 넣을 수 있다`() {
        val queue: Queue<Int> = LinkedList()

        queue.add(1)
        queue.offer(1)

        assertThat(queue).hasSize(2)
    }

    @Test
    fun `큐에서 데이터를 꺼낼 수 있다`() {
        val queue: Queue<Int> = LinkedList()

        queue.add(1)
        queue.offer(2)

        assertThat(queue.poll()).isEqualTo(1)
        assertThat(queue).hasSize(1)

        assertThat(queue.remove()).isEqualTo(2)
        assertThat(queue).hasSize(0)
    }

}
