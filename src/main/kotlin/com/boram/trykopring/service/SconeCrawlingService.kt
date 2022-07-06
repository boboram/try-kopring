package com.boram.trykopring.service

import org.springframework.stereotype.Service

@Service
class SconeCrawlingService : NaverShopCrawlingService() {

    fun getBestSconeList() :String {
        val res = getBestList("비건스콘")

        return res
    }
}