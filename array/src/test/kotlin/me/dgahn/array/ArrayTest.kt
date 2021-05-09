package me.dgahn.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ArrayTest {

    @Test
    fun `배열을 선언할 수 있다`() {
        val array = Array(5) { 0 }

        array.forEach { assertThat(it).isEqualTo(0) }
    }

    @Test
    fun `배열을 선언하고 특정 인덱스의 값을 가져올 수 있다`() {
        val array = Array(5) { 0 }
        array[0] = 1

        assertThat(array[0]).isEqualTo(1)
    }

    @Test
    fun `문자열에서 특정 문자가 존재하는 문자를 셀 수 있다`() {
        val array = arrayOf("man", "woman", "new", "version");

        val result = array.count { str -> str.contains("m") }

        assertThat(result).isEqualTo(2)
    }

}
