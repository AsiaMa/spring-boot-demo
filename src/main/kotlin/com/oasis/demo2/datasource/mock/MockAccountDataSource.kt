package com.oasis.demo2.datasource.mock

import com.oasis.demo2.datasource.AccountDataSource
import com.oasis.demo2.domain.entity.AccountEntity
import org.springframework.stereotype.Repository

@Repository
class MockAccountDataSource : AccountDataSource {

    val accounts = listOf(
        AccountEntity(1, "Alice", "112233", 1),
        AccountEntity(2, "Jack", "123", 1),
        AccountEntity(3, "Pony", "666", 2)
    )


    override fun retrieveAccounts(): Collection<AccountEntity> = accounts
}