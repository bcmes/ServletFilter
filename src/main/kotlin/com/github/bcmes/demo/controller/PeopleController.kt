package com.github.bcmes.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.ContentCachingRequestWrapper
import javax.servlet.http.HttpServletRequest

@RestController
class PeopleController {

    private val peopleList: MutableList<Any> = mutableListOf()

    @GetMapping("/peoples")
    fun getPeople(): MutableList<Any> {
        return peopleList
    }

    @PostMapping("/peoples")
    fun postPeople(@RequestBody any: Any, httpServletRequest: HttpServletRequest) {
        peopleList.add(any)

        //Como meu HttpServletRequest esta cacheado, e so injetar e ler quantas vezes desejar.
        val req = httpServletRequest as ContentCachingRequestWrapper
        val read1 = req.contentAsByteArray.toString(Charsets.UTF_8)
        println(read1)
        val read2 = req.contentAsByteArray.toString(Charsets.UTF_8)
        println(read2)
    }

}