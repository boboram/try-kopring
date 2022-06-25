package com.boram.trykopring.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("wise")
class WiseSayingController {
    /**
     * @RequestMapping("/restTest")
    public String restTest(@RequestParam String str){
    return str + " : Rest Test 완료!!!";
    }
     */

    @RequestMapping("/test")
    fun test() :String{
        val saying = "99도까지 온도를 올려놓아도 마지막 1도를 넘기지 못하면 영원히 물은 끓지 않는다. 물을 끓이는 건 마지막 1도. 포기하고 싶은 바로 그 1분을 참아내는 것이다."

        println(saying)

        return saying
    }
}