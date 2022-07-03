package com.boram.trykopring.grammer.collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestHashSet {

    @Test
    @DisplayName("hashsetof 선언 테스트 코드 - 순서가 정해져 있지 않다.")
    fun testHashSetOf()
    {
        val hashSet = getHashSetOfData()

        hashSet.add("dsf")

        assertNotEquals("[bona, boram, boboram, dsf]", hashSet.toString())
        assertEquals("[boram, boboram, bona, dsf]", hashSet.toString())
    }

    @Test
    @DisplayName("hashsetof 선언 테스트 코드 - 중복이 허용되지 않는다..")
    fun testHashSetOfAddDuplicateValue()
    {
        val hashSet = getHashSetOfData()

        hashSet.add("bona")

        assertNotEquals("[bona, boram, boboram]", hashSet.toString())
        assertEquals("[boram, boboram, bona]", hashSet.toString())
    }

    @Test
    @DisplayName("hashsetof 선언 테스트 코드 - 순서가 정해져 있지 않다.")
    fun testMutableHashSetOf()
    {
        val hashSet = getHashSetOfData()

        hashSet.add("dsf")

        assertNotEquals("[bona, boram, boboram, dsf]", hashSet.toString())
        assertEquals("[boram, boboram, bona, dsf]", hashSet.toString())
    }

    private fun getHashSetOfData() = hashSetOf("bona", "boram", "boboram")
}