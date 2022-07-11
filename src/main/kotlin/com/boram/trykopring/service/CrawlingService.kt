package com.boram.trykopring.service

import com.boram.trykopring.dto.Scone
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


interface CrawlingService {

    fun getSiteCrawling(searchSite:String):Document {
        return Jsoup.connect(searchSite).get()
    }

    fun getBestList(keyword:String):MutableList<Scone>
}