package me.dgahn.linkedlist

private const val HEAD_INDEX = 0
private const val FIRST_INDEX = 1
private const val INIT_VALUE = -1

class SingleLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var lastIndex = INIT_VALUE

    fun add(node: Node<T>) {
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }
        lastIndex++
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

    fun add(index: Int, node: Node<T>) {
        when {
            index == HEAD_INDEX -> addHead(node)
            index > lastIndex -> addTail(node)
            else -> addMiddle(index, node)
        }
        lastIndex++
    }

    private fun addTail(node: Node<T>) {
        tail?.next = node
        tail = node
    }

    private fun addMiddle(index: Int, node: Node<T>) {
        var prev = head
        for (i in FIRST_INDEX until index) {
            prev = prev?.next
        }
        node.next = prev?.next?.next
        prev?.next = node
    }

    private fun addHead(node: Node<T>) {
        node.next = head?.next
        head = node
        return
    }

    fun get(index: Int): Node<T>? {
        var current = head
        for (i in FIRST_INDEX..index) {
            current = current?.next
        }
        return current
    }

    fun remove(index: Int) {
        when (index) {
            HEAD_INDEX -> removeHead()
            lastIndex -> removeTail(index)
            else -> removeMiddle(index)
        }
    }

    private fun removeHead() {
        head = head?.next
    }

    private fun removeMiddle(index: Int) {
        var prev = head
        for (i in FIRST_INDEX until index) {
            prev = prev?.next
        }
        prev?.next = prev?.next?.next
    }

    private fun removeTail(index: Int) {
        var prev = head
        for (i in FIRST_INDEX until index) {
            prev = prev?.next
        }
        prev?.next = null
        tail = prev
    }

}
