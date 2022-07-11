package com.boram.trykopring.web

import com.boram.trykopring.service.CrawlingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class SconeCrawlingController {

    @Autowired
    private lateinit var crawlingService: CrawlingService
    @GetMapping("/scone/crawling")
    fun list(model:Model): String {

        val sconeList = crawlingService.getBestList("비건 스콘")

        model.addAttribute("sconeList", sconeList)
        return "scone/sconeList"
    }
}