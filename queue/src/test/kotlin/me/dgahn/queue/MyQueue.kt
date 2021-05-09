package me.dgahn.queue

import java.util.*

class MyQueue<T> {
    private val queue = LinkedList<T>()

    val size: Int
        get() = queue.size

    fun add(t: T) {
        queue.add(t)
    }

    fun poll(): T? {
        val first = kotlin.runCatching { queue.first }.getOrNull()
        if (queue.isNotEmpty()) {
            queue.removeFirst()
        }
        return first
    }

}
