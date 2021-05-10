package me.dgahn.linkedlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SingleLinkedListTest {

    @Test
    fun `단일 링크드리스트가 비어있을 때 값을 추가하면 head값과 tail값이 된다`() {
        val linkedList = SingleLinkedList<Int>()
        val node = Node(1, null)
        linkedList.add(node)
        assertThat(linkedList.getHead()).isEqualTo(node)
        assertThat(linkedList.getTail()).isEqualTo(node)
    }

    @Test
    fun `단일 링크드리스트의 값을 추가하면 추가된 값이 Tail이 된다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)

        assertThat(linkedList.getTail()).isEqualTo(hundredNode)
        assertThat(linkedList.getHead()).isEqualTo(firstNode)
        assertThat(linkedList.getHead()?.next).isEqualTo(hundredNode)
    }

    @Test
    fun `단일 링크드리스트의 값을 출력할 수 있다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)

        assertThat(linkedList.printAll()).isEqualTo("1 -> 100")
    }

}
