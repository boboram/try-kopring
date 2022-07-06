package com.boram.trykopring.web

import com.boram.trykopring.common.constant.WiseSayingApiPath
import com.boram.trykopring.service.WiseSayingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

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

    @RequestMapping("/redirect-advice")
    fun redirectAdvice():RedirectView {
        val redirect = RedirectView()
        redirect.setUrl(WiseSayingApiPath);

        return redirect
    }

    @RequestMapping("/advice")
    fun advice():String {
        val advice = wiseSayingService.getOneAdvice()

        println(advice)
        return advice
    }
}