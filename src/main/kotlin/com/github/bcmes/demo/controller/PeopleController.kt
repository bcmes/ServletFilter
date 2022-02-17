package com.github.bcmes.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PeopleController {

    private val peopleList: MutableList<Any> = mutableListOf()

    @GetMapping("/peoples")
    fun getPeople(): MutableList<Any> {
        return peopleList
    }

    @PostMapping("/peoples")
    fun postPeople(@RequestBody any: Any) {
        peopleList.add(any)
    }

}