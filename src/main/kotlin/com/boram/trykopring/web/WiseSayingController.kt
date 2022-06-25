package com.boram.trykopring.web

import com.boram.trykopring.service.WiseSayingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("wise")
class WiseSayingController {

    @Autowired
    private lateinit var wiseSayingService: WiseSayingService

    @RequestMapping("/test")
    fun test() :String{
        val saying = wiseSayingService.sample()

        println(saying)

        return saying
    }
}