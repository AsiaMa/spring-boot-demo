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
    inner class GetAccountsByName {

        @Test
        fun `should return all match accounts with  the given account name`() {
            // given
            val accountName = "o"

            // when
            val accounts = accountMapper.findByName(accountName)
            // then
            assertThat(accounts).isNotEmpty
        }

        @Test
        fun `should return empty list if the account name does not exists`() {
            // given
            val invalidAccountName = "oop"

            // when
            val accounts = accountMapper.findByName(invalidAccountName)

            // then
            assertThat(accounts.size).isEqualTo(0)
        }
    }

    @Nested
    @DisplayName("get account")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAccountById {

        @Test
        fun `should return an account with the given account id`() {
            // given
            val accountId = 1

            // when
            val account = accountMapper.selectLinkById(accountId)

            // then
            assertThat(account.accountId).isEqualTo(1)
            assertThat(account.address.addressName).isEqualTo("BeiJing")
        }

        @Test
        fun `should return null if the account id does not exists`() {
            // given
            val invalidAccountId = -1

            // when
            val account = accountMapper.selectLinkById(invalidAccountId)

            // then
            assertThat(account).isNull()
        }
    }
}