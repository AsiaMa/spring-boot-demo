package com.oasis.demo2.service.impl

import com.oasis.demo2.dao.AccountMapper
import com.oasis.demo2.datasource.AccountDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AccountServiceImplTest {

    private val dataSource: AccountDataSource = mockk(relaxed = true)

    private val accountMapper: AccountMapper = mockk(relaxed = true)

    private val accountService = AccountServiceImpl(accountMapper, dataSource)

    @Test
    fun `should call its data source to retrieve accounts`() {
        // given
        //every { dataSource.retrieveAccounts() } returns emptyList()
        // when
        val accounts = accountService.getAccounts()
        // then
        verify(exactly = 1) { dataSource.retrieveAccounts() }
    }
}