package com.oasis.demo2.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockAccountDataSourceTest {

    private val mockAccountDataSource: MockAccountDataSource = MockAccountDataSource()

    @Test
    fun `should provide a collection of accounts`() {
        // given

        // when
        val accounts = mockAccountDataSource.retrieveAccounts()

        // then
        assertThat(accounts).isNotEmpty
        assertThat(accounts.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        // given

        // when
        val accounts = mockAccountDataSource.retrieveAccounts()
        // then
        assertThat(accounts).allMatch { it.accountName!!.isNotBlank() }
        assertThat(accounts).anyMatch { it.accountId != 2 }
        assertThat(accounts).allMatch { it.accountId != 0 }
    }
}