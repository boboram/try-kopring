package com.boram.trykopring.web

import com.boram.trykopring.service.SconeCrawlingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("scone")
class SconeCrawlingController {

    @Autowired
    private lateinit var sconeCrawlingService: SconeCrawlingService

    @RequestMapping("/crawling")
    fun list(): String {

        val res = sconeCrawlingService.getBestSconeList()

        return res
    }
}