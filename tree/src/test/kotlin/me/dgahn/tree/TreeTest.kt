package me.dgahn.tree

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TreeTest {

    @Test
    fun `이진 트리에 값이 없는데 값을 추가하면 head의 값이 된다`() {
        val tree = Tree(null)

        tree.add(10)

        assertThat(tree.head?.value).isEqualTo(10)
    }

    @Test
    fun `이진 트리에서 head의 값보다 작은 값을 넣으면 left에 저장된다`() {
        val tree = Tree(null)

        tree.add(10)
        tree.add(9)

        assertThat(tree.head?.left?.value).isEqualTo(9)
    }

    @Test
    fun `이진 트리에서 head의 값보다 큰 값을 넣으면 right에 저장된다`() {
        val tree = Tree(null)

        tree.add(10)
        tree.add(11)

        assertThat(tree.head?.right?.value).isEqualTo(11)
    }

    @Test
    fun `헤드의 값이 존재하지 않으면 null을 반환한다`() {
        val tree = Tree(null)

        assertThat(tree.search(1)).isNull()
    }

    @Test
    fun `트리에 존재하는 값이 존재하면 찾을 수 있다`() {
        val tree = Tree(null)

        tree.add(3)
        tree.add(2)
        tree.add(4)
        tree.add(5)

        assertThat(tree.search(4)).isNotNull
        assertThat(tree.search(4)?.value).isEqualTo(4)
    }

    @Test
    fun `트리에 존재하지 않는 값을 찾으면 null을 반환한다`() {
        val tree = Tree(null)

        tree.add(3)
        tree.add(2)
        tree.add(4)
        tree.add(5)

        assertThat(tree.search(10)).isNull()
    }

}
