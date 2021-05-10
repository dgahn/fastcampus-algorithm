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

    @Test
    fun `단일 링크드리스트의 중간에 값을 추가할 수 있다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)

        val fiftyNode = Node(50, null)
        linkedList.add(1, fiftyNode)

        val result = linkedList.get(1)
        assertThat(result).isEqualTo(fiftyNode)
    }

    @Test
    fun `단일 링크드리스트의 처음에 값을 추가할 수 있다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)

        val fiftyNode = Node(50, null)
        linkedList.add(0, fiftyNode)

        val result = linkedList.get(0)
        assertThat(result).isEqualTo(fiftyNode)
    }

    @Test
    fun `단일 링크드리스트의 끝에 값을 추가할 수 있다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)

        val fiftyNode = Node(50, null)
        linkedList.add(2, fiftyNode)

        val result = linkedList.get(2)
        assertThat(result).isEqualTo(fiftyNode)
        assertThat(linkedList.getTail()).isEqualTo(fiftyNode)
    }

    @Test
    fun `단일 링크드리스트의 값을 삭제할 수 있다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        val fiftyNode = Node(50, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)
        linkedList.add(fiftyNode)

        linkedList.remove(1)
        assertThat(linkedList.get(1)).isNotEqualTo(hundredNode)
        assertThat(linkedList.printAll()).isEqualTo("1 -> 50")
    }

    @Test
    fun `단일 링크드리스트의 헤드 값을 삭제할 수 있다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        val fiftyNode = Node(50, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)
        linkedList.add(fiftyNode)

        linkedList.remove(0)
        assertThat(linkedList.get(0)).isNotEqualTo(firstNode)
        assertThat(linkedList.printAll()).isEqualTo("100 -> 50")
    }

    @Test
    fun `단일 링크드리스트의 tail 값을 삭제할 수 있다`() {
        val linkedList = SingleLinkedList<Int>()
        val firstNode = Node(1, null)
        val hundredNode = Node(100, null)
        val fiftyNode = Node(50, null)
        linkedList.add(firstNode)
        linkedList.add(hundredNode)
        linkedList.add(fiftyNode)

        linkedList.remove(2)
        assertThat(linkedList.getTail()).isEqualTo(hundredNode)
        assertThat(linkedList.printAll()).isEqualTo("1 -> 100")
    }

}
