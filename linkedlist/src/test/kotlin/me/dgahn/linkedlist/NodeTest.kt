package me.dgahn.linkedlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NodeTest {

    @Test
    fun `Node를 생성할 수 있다`() {
        val node = Node(1, null)

        assertThat(node.data).isEqualTo(1)
        assertThat(node.next).isNull()
    }

    @Test
    fun `Node의 다음을 연결할 수 있다`() {
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)

        firstNode.next = hundredNode

        assertThat(firstNode.next).isEqualTo(hundredNode)
    }

}
