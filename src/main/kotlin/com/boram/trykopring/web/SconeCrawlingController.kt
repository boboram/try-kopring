package com.boram.trykopring.web

import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("scone")
class SconeCrawlingController {

    @RequestMapping("/crawling")
    fun list(): String {

        val keyword = "비건스콘"
        val searchSite = "https://search.shopping.naver.com/search/all?frm=NVSCPRO&origQuery=$keyword&pagingIndex=1&pagingSize=90&productSet=total&query=$keyword&sort=review&timestamp=&viewType=list"
        val doc = Jsoup.connect(searchSite + keyword).get()

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