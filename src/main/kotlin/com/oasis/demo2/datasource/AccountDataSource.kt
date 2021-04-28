package com.oasis.demo2.datasource

import com.oasis.demo2.domain.entity.AccountEntity

interface AccountDataSource {
    fun retrieveAccounts(): Collection<AccountEntity>
}