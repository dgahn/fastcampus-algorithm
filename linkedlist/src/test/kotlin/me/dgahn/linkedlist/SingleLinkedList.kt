package me.dgahn.linkedlist

class SingleLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun add(node: Node<T>) = if (head == null) {
        head = node
        tail = node
    } else {
        tail!!.next = node
        tail = node
    }

    fun getHead(): Node<T>? = this.head

    fun getTail(): Node<T>? = this.tail

    fun printAll(): String {
        if (head == null) {
            return ""
        }
        val builder = StringBuilder(head!!.data.toString())
        var node = head?.next
        while (node != null) {
            builder.append(" -> ")
            builder.append(node.data)
            node = node.next
        }
        return builder.toString()
    }

}
