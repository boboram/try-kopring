package com.boram.trykopring.grammer.base

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestCollection {

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