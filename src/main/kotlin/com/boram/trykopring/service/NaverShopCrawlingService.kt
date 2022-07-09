package com.boram.trykopring.service

import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class NaverShopCrawlingService : CrawlingService{

    override fun getBestList(keyword:String):String {
        val searchSite = "https://search.shopping.naver.com/search/all?frm=NVSCPRO&origQuery=$keyword&pagingIndex=1&pagingSize=90&productSet=total&query=$keyword&sort=review&timestamp=&viewType=list"

        val doc = getSiteCrawling(searchSite)

        var res = """
            ###$keyword 메인 5###
            
        """.trimIndent()

        doc.select(".basicList_item__2XT81").forEach {
            val titleEl: Elements = it.select(".basicList_title__3P9Q7").select("a")

            val itemRes = """
                [${titleEl.attr("title")}]
                주소: [${titleEl.attr("href")}]
                가격: ${it.select(".basicList_price_area__1UXXR > .basicList_price__2r23_ > span > .price_num__2WUXn").text()}
                
                
            """.trimIndent()

            res += itemRes

            println(itemRes)

        }

        return res
    }
}