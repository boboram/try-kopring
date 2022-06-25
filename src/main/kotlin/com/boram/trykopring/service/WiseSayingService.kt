package com.boram.trykopring.service

import org.springframework.stereotype.Service

@Service
class WiseSayingService {

    fun sample() :String {
        return "99도까지 온도를 올려놓아도 마지막 1도를 넘기지 못하면 영원히 물은 끓지 않는다. 물을 끓이는 건 마지막 1도. 포기하고 싶은 바로 그 1분을 참아내는 것이다."
    }
}