package com.boram.trykopring.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document


interface CrawlingService {

    fun getSiteCrawling(searchSite:String):Document {
        return Jsoup.connect(searchSite).get()
    }

    fun getBestList(keyword:String):String
}