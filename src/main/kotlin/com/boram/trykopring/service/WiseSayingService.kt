package com.boram.trykopring.service

import com.boram.trykopring.common.constant.WiseSayingApiPath
import com.boram.trykopring.dto.WiseSaying
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WiseSayingService {

    fun sample() :String {
        return "99도까지 온도를 올려놓아도 마지막 1도를 넘기지 못하면 영원히 물은 끓지 않는다. 물을 끓이는 건 마지막 1도. 포기하고 싶은 바로 그 1분을 참아내는 것이다."
    }

    fun getOneAdvice():String {
        val advice = callWiseSayingApi()

        return advice.advice
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