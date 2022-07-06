package com.boram.trykopring.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class NaverShopCrawlingService : CrawlingService(){

    fun getBestList(keyword:String):String {
        val searchSite = "https://search.shopping.naver.com/search/all?frm=NVSCPRO&origQuery=$keyword&pagingIndex=1&pagingSize=90&productSet=total&query=$keyword&sort=review&timestamp=&viewType=list"

        val doc = getSiteCrawling(keyword, searchSite)

        var res = """
            ###비건 스콘 메인 5###
            
        """.trimIndent()

        doc.select(".basicList_item__2XT81").forEach {
            val titleEl: Elements = it.select(".basicList_title__3P9Q7").select("a")
            val title = titleEl.attr("title")
            val href = titleEl.attr("href")
            val price = it.select(".basicList_price_area__1UXXR > .basicList_price__2r23_ > span > .price_num__2WUXn").text()

            val itemRes = """
                [$title]
                주소: [$href]
                가격: $price
                
                
            """.trimIndent()

            res += itemRes

            println(itemRes)

        }

        return res
    }
}