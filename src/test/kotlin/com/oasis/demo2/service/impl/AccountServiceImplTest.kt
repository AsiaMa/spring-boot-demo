package com.oasis.demo2.service.impl

import com.oasis.demo2.dao.AccountMapper
import com.oasis.demo2.datasource.AccountDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
internal class AccountServiceImplTest {

    @MockBean
    lateinit var accountMapper: AccountMapper
    private val dataSource: AccountDataSource = mockk(relaxed = true)
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