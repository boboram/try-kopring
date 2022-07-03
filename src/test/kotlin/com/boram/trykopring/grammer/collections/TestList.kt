package com.boram.trykopring.grammer.collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestList {

    @Test
    @DisplayName("list 컬렉션 테스트 코드")
    fun testListOf() {
        val list = getListData()

        assertEquals(3, list.size)

        //list.add("new") 불가능
        //list.removeAt(1) 불가능
    }

    @Test
    @DisplayName("mutable data로 받아도 문제는 되지 않는다. add는 불가능하다.")
    fun testListOfUseMutableListData() {
        val list : List<String> = getMutableListData()

        assertEquals(3, list.size)

        //list.add("new") 불가능
    }

    @Test
    @DisplayName("mutable 컬렉션 테스트 코드")
    fun testMutableListOf() {
        val list = getMutableListData()

        assertEquals(3, list.size)
        assertEquals("boram", list.get(0))
    }

    @Test
    @DisplayName("mutable 컬렉션 add 테스트 코드")
    fun testAddMutableListOf() {
        val list = getMutableListData()

        assertEquals(3, list.size)

        list.add("new")

        assertEquals(4, list.size)
        assertEquals("new", list.get(3))
    }

    @Test
    @DisplayName("mutable 컬렉션 add 테스트 코드 - 중복이 가능하다.")
    fun testAddDuplicateValueMutableListOf() {
        val list = getMutableListData()

        assertEquals(3, list.size)

        list.add("new")

        assertEquals(4, list.size)
        assertEquals("new", list.get(3))

        list.add("new")
        assertEquals(5, list.size)
        assertEquals("new", list.get(4))
    }

    @Test
    @DisplayName("mutable 컬렉션 delete 테스트 코드")
    fun testDeleteMutableListOf() {

        val list = getMutableListData()
        //("boram", "bona", "boboram")

        list.removeAt(0)
        //("bona", "boboram")

        assertFalse(list.contains("boram"))

        list.removeLast()
        //("bona")

        assertFalse(list.contains("boboram"))

        list.add("boram")
        //("bona", "boram)

        assertTrue(list.contains("boram"))

        list.removeAll(listOf("boram", "bona"))

        assertEquals(0, list.size)
    }

    private fun getListData() = listOf("boram", "bona", "boboram")
    private fun getMutableListData() = mutableListOf("boram", "bona", "boboram")
}