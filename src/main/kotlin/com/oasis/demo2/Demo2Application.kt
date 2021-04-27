package com.oasis.demo2

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.oasis.demo2.dao")
class Demo2Application

fun main(args: Array<String>) {
    runApplication<Demo2Application>(*args)
}
