package com.boram.trykopring.service

import com.boram.trykopring.common.constant.WiseSayingApiPath
import com.boram.trykopring.dto.WiseSaying
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate


class TestWiseSayingService {

    @Test
    @DisplayName("명언 API 호출 테스트")
    fun testCallWiseSayingApi() {
        val restTemplate = RestTemplate()

        val response = restTemplate.getForEntity(WiseSayingApiPath, String::class.java)

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK)

        val adviceVo: WiseSaying = Gson().fromJson(
            JsonParser().parse(response.body.toString()).getAsJsonObject().get("slip").toString(),
            WiseSaying::class.java
        )

        println(adviceVo.id)
        println(adviceVo.advice)
    }

    @Test
    @DisplayName("path가 올바른지 확인")
    fun testEqualsWiseSayingApiPath() {
        assertThat(WiseSayingApiPath).isEqualTo("https://api.adviceslip.com/advice")
    }

    @Test
    @DisplayName("advice 얻어오기 테스트")
    fun testGetAdviceData(){
        val advice:WiseSaying = callWiseSayingApi()

        assertThat(advice.advice).isNotNull()
        assertThat(advice.id).isNotNull()
    }

    private fun callWiseSayingApi():WiseSaying {
        val restTemplate = RestTemplate()

        val response = restTemplate.getForEntity(WiseSayingApiPath, String::class.java)

        val advice: WiseSaying = Gson().fromJson(
            JsonParser().parse(response.body.toString()).getAsJsonObject().get("slip").toString(),
            WiseSaying::class.java
        )

        return advice
    }

}