package com.haulmont.easywallet.controller

import com.haulmont.platformcommon.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class HelloController(private val userService: UserService) {
    @GetMapping("/hello")
    fun hello(@RequestParam(defaultValue = "World") name: String): String {
        return "Hello $name!"
    }

    @GetMapping("/myhello")
    fun helloMyService(): String {
        return "Hello from ${userService.helloMyService()}"
    }
}
