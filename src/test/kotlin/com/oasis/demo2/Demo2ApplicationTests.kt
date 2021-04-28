package com.oasis.demo2

import com.oasis.demo2.dao.AccountMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    lateinit var accountMapper: AccountMapper

    @Test
    fun contextLoads() {
    }

    @Test
    fun testSelect() {
        val accountList = accountMapper.selectList(null)
        assertThat(accountList.size).isEqualTo(2)
        println(accountList)
        assertThat(accountList[0].accountName).isEqualTo("Tom")
    }
}
