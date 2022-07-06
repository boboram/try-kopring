package com.boram.trykopring.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

@Service
class CrawlingService {

    fun getSiteCrawling(keyword:String, searchSite:String):Document {
        return Jsoup.connect(searchSite + keyword).get()
    }
}