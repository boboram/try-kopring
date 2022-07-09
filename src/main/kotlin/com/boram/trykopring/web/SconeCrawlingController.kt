package com.boram.trykopring.web

import com.boram.trykopring.service.CrawlingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("scone")
class SconeCrawlingController {

    @Autowired
    private lateinit var crawlingService: CrawlingService
    @RequestMapping("/crawling")
    fun list(): String {

        val res = crawlingService.getBestList("비건 스콘")

        return res
    }
}