package com.oasis.demo2.datasource.mock

import com.oasis.demo2.datasource.AccountDataSource
import com.oasis.demo2.domain.entity.AccountEntity
import org.springframework.stereotype.Repository

@Repository
class MockAccountDataSource : AccountDataSource {

//    val accounts = listOf(
//        AccountEntity(1, "Alice", "112233"),
//        AccountEntity(2, "Jack", "123"),
//        AccountEntity(3, "Pony", "666")
//    )
val accounts = emptyList<AccountEntity>()

    override fun retrieveAccounts(): Collection<AccountEntity> = accounts
}