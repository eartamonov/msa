package com.haulmont.platformcommon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlatformCommonApplication

fun main(args: Array<String>) {
	runApplication<PlatformCommonApplication>(*args)
}
