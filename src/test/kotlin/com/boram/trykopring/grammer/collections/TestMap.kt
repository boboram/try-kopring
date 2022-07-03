package com.boram.trykopring.grammer.collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestMap {
    @Test
    @DisplayName("map of 선언 테스트 코드 read only")
    fun testMapOf()
    {
        val mapOf = getMapOf()

        assertEquals("boram", mapOf.get("real"))
        assertNull(mapOf.get("nickname"))
//        mapOf.put() 불가능
    }

    @Test
    @DisplayName("map 타입 데이터 mutable map of 데이터를 받아도 수정 불가능")
    fun testMapOfUseMutableMapOfData()
    {
        val mapOf:Map<String, String> = getMutableMapOf()

        assertEquals("boram", mapOf.get("real"))
        assertNull(mapOf.get("nickname"))
//        mapOf.put() 불가능
    }

    @Test
    @DisplayName("mutable map 테스트 코드")
    fun testMutableMapOf() {
        val mutableMap = getMutableMapOf()

        assertEquals(3, mutableMap.size)
        assertEquals("boram", mutableMap.get("real"))
    }

    @Test
    @DisplayName("mutable map put 테스트 코드")
    fun testPutMutableMapOf() {
        val mutableMap = getMutableMapOf()

        assertEquals(3, mutableMap.size)

        mutableMap.put("nickname", "bonas")

        assertEquals(4, mutableMap.size)
        // assertEquals("bonas", mutableMap.get(3)) //불가능
        assertEquals("bonas", mutableMap.get("nickname")) //키명으로 획득해야 함
    }

    @Test
    @DisplayName("mutable map add 테스트 코드 - 중복이 불가능하다.")
    fun testAddDuplicateValueMutableMapOf() {
        val mutableMap = getMutableMapOf()

        assertEquals(3, mutableMap.size)

        mutableMap.put("new", "bonas")

        assertEquals(4, mutableMap.size)
        assertEquals("bonas", mutableMap.get("new"))


        mutableMap.put("new", "bonas")
        assertEquals(4, mutableMap.size)
    }

    @Test
    @DisplayName("mutable map delete 테스트 코드")
    fun testDeleteMutableMapOf() {

        val mutableMap = getMutableMapOf()
        //{real=boram, company=bona, github=boboram}

        mutableMap.remove("company")
        //{real=boram, github=boboram}

        assertFalse(mutableMap.containsValue("bona"))

        mutableMap.put("company", "bona")
        //{real=boram, github=boboram, company=bona}

        assertTrue(mutableMap.containsKey("real"))
        assertTrue(mutableMap.containsValue("boram"))
    }

    private fun getMapOf() = mapOf("real" to "boram", "company" to "bona", "github" to "boboram")
    private fun getMutableMapOf() = mutableMapOf("real" to "boram", "company" to "bona", "github" to "boboram")
}