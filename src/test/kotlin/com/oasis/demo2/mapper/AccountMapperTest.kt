package com.oasis.demo2.mapper

import com.oasis.demo2.dao.AccountMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AccountMapperTest @Autowired constructor(@Autowired val accountMapper: AccountMapper) {

    @Nested
    @DisplayName("get accounts")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAccounts {

        @Test
        fun `should provide a collection of accounts with given account name`() {
            // given
            val accountName = "o"

            // when
            val accounts = accountMapper.findByName(accountName)
            // then
            assertThat(accounts).isNotEmpty
        }
    }
}