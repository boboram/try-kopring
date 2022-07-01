package com.boram.trykopring.grammer.base

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestFunction {

    @Test
    @DisplayName("기본값이 존재하지 않는 함수 호출")
    fun testTransferHelloNotDefaultValue() {
        val helloTxtKo = transferHelloNotDefaultValue(CountryCode.KR, "")

        assertEquals("안녕하세요", helloTxtKo)
    }

    @Test
    @DisplayName("기본값이 존재하지 않는 함수 호출 with token")
    fun testTransferHelloNotDefaultValueWithToken() {
        val helloTxtJp = transferHelloNotDefaultValue(CountryCode.JP, "!!")

        assertEquals("こんにちは!!", helloTxtJp)
    }

    @Test
    @DisplayName("기본값이 존재하지 않는 함수 호출, 국가별 비교")
    fun testCompareTransferHelloNotDefaultValue() {
        val helloTxtKo = transferHelloNotDefaultValue(CountryCode.KR, "")
        val helloTxtCN = transferHelloNotDefaultValue(CountryCode.CN, "")
        val helloTxtJP = transferHelloNotDefaultValue(CountryCode.JP, "")

        assertNotEquals(helloTxtKo, helloTxtCN)
        assertNotEquals(helloTxtKo, helloTxtJP)
        assertNotEquals(helloTxtCN, helloTxtJP)
    }

    @Test
    @DisplayName("추임새 기본값이 있는 함수 token 값 보내지 않고 테스트")
    fun testTransferHelloWithTokenDefault() {
        val helloTxtCN = transferHelloWithTokenDefault(CountryCode.CN)

        assertEquals("你好!!", helloTxtCN)
    }

    @Test
    @DisplayName("추임새 기본값이 있는 함수 token 값 보내기 테스트")
    fun testTransferHelloWithTokenDefaultSendToken() {
        val helloTxtJP = transferHelloWithTokenDefault(CountryCode.JP, "")

        assertNotEquals("こんにちは!!", helloTxtJP)
    }

    @Test
    @DisplayName("국가코드와 추임새 기본값이 있는 함수 국가코드 값 보내기 테스트")
    fun testTransferHelloWithCCDefaultAndTokenDefault() {
        val helloTxtJP = transferHelloWithCCDefaultAndTokenDefault(CountryCode.JP)

        assertNotEquals("안녕하세요!!", helloTxtJP)
    }

    @Test
    @DisplayName("국가코드와 추임새 기본값이 있는 함수 파라미터 없이 테스트")
    fun testTransferHelloWithCCDefaultAndTokenDefaultNotSendParam() {
        val helloTxtKo = transferHelloWithCCDefaultAndTokenDefault()

        assertEquals("안녕하세요!!", helloTxtKo)
    }

    private fun transferHelloNotDefaultValue(countryCode:CountryCode, token:String) :String
    {
        var res  = when(countryCode) {
            CountryCode.KR -> "안녕하세요"
            CountryCode.CN -> "你好"
            CountryCode.JP -> "こんにちは"
        }

        return "$res$token"
    }

    private fun transferHelloWithTokenDefault(countryCode:CountryCode, token:String="!!") :String
    {
        var res  = when(countryCode) {
            CountryCode.KR -> "안녕하세요"
            CountryCode.CN -> "你好"
            CountryCode.JP -> "こんにちは"
        }

        return "$res$token"
    }

    private fun transferHelloWithCCDefaultAndTokenDefault(countryCode:CountryCode=CountryCode.KR, token:String="!!") :String
    {
        var res  = when(countryCode) {
            CountryCode.KR -> "안녕하세요"
            CountryCode.CN -> "你好"
            CountryCode.JP -> "こんにちは"
        }

        return "$res$token"
    }

    enum class CountryCode {
        KR, JP, CN
    }
}