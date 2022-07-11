package com.boram.trykopring.service

import com.boram.trykopring.dto.Scone
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class NaverShopCrawlingService : CrawlingService{

    override fun getBestList(keyword:String):MutableList<Scone> {
        val searchSite = "https://search.shopping.naver.com/search/all?frm=NVSCPRO&origQuery=$keyword&pagingIndex=1&pagingSize=90&productSet=total&query=$keyword&sort=review&timestamp=&viewType=list"

        val doc = getSiteCrawling(searchSite)

        val itemList = mutableListOf<Scone>()

        doc.select(".basicList_item__2XT81").forEach {
            val titleEl: Elements = it.select(".basicList_title__3P9Q7").select("a")

            val scone = Scone(
                titleEl.attr("title"),
                it.select(".basicList_price_area__1UXXR > .basicList_price__2r23_ > span > .price_num__2WUXn").text(),
                titleEl.attr("href")
            )
           println(scone.toString())

            itemList.add(scone)

        }

        return itemList
    }
}