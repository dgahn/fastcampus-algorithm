package me.dgahn.stack

import java.util.*

class MyStack<T> {

    private val stack = LinkedList<T>()

    fun push(t: T): T {
        stack.add(t)
        return stack.last
    }

    fun pop(): T? {
        val last = kotlin.runCatching { stack.last }.getOrNull()
        if (stack.isNotEmpty()) {
            stack.removeLast()
        }
        return last
    }

}
