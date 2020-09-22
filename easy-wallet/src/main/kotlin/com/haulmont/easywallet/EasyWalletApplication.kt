package com.haulmont.easywallet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.haulmont.easywallet", "com.haulmont.platformcommon"])
@SpringBootApplication
class EasyWalletApplication

fun main(args: Array<String>) {
	runApplication<EasyWalletApplication>(*args)
}
