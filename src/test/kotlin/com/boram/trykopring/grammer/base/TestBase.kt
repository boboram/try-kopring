package com.boram.trykopring.grammer.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.StringReader

class TestBase {

    @Test
    @DisplayName("if절 테스트 코드")
    fun testIf() {
        val num = 1

        val str = if (num === 1) "num is 1" else "num is not 1"

        assertEquals("num is 1", str)
    }

    @Test
    @DisplayName("식이 본문인 함수 테스트")
    fun testExpressionIsMain() {
        val num = 1

        val str = numIs(num)

        assertEquals("num is 1", str)
    }

    private fun numIs(num:Int):String = if (num === 1) "num is 1" else "num is not 1"

    @Test
    @DisplayName("코틀린 예외 테스트 null을 받음")
    fun testKotlinExceptionGetNull() {
        val reader = BufferedReader(StringReader("not a number"))

        assertEquals(null, readNumber(reader))
    }

    @Test
    @DisplayName("코틀린 예외 테스트 제대로 된 숫자를 받음")
    fun testKotlinExceptionGetNotNull() {
        val reader = BufferedReader(StringReader("1"))

        assertEquals(1, readNumber(reader))
    }

    //throws 절이 없다(자바와의 가장 큰 차이)
    private fun readNumber(reader: BufferedReader): Int? {
        try {
            val line = reader.readLine()
            return Integer.parseInt(line)
        }
        //예외타입을 :옆에 쓴다
        catch (e: NumberFormatException) {
            return null
        }
        finally { //finally는 자바와 똑같이 동작
            reader.close()
        }
    }

    @Test
    @DisplayName("코틀린 예외 테스트 null을 받음")
    fun testGetNumberFormatException() {
        assertThrows(NumberFormatException::class.java){getNumberFormatException()}
    }

    private fun getNumberFormatException() {
        throw NumberFormatException()
    }
}