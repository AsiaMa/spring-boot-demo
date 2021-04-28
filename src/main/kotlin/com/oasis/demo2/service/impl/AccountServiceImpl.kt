package com.oasis.demo2.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.oasis.demo2.dao.AccountMapper
import com.oasis.demo2.datasource.AccountDataSource
import com.oasis.demo2.domain.entity.AccountEntity
import com.oasis.demo2.service.IAccountService
import org.springframework.stereotype.Service

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
@Service
class AccountServiceImpl(
    private val accountMapper: AccountMapper,
    private val dataSource: AccountDataSource
) : ServiceImpl<AccountMapper, AccountEntity>(),
    IAccountService {

    override fun findById(accountId: Int): AccountEntity {
        return accountMapper.selectById(accountId) ?: throw NoSuchElementException("没有id为: $accountId 的用户")
    }

    override fun getAccounts(): Collection<AccountEntity> = dataSource.retrieveAccounts()

    override fun addAccount(account: AccountEntity): AccountEntity {
        val existsAccount = accountMapper.selectById(account.accountId)
        if (existsAccount != null) {
            throw IllegalArgumentException("用户id为 ${existsAccount.accountId} 已存在")
        }
        accountMapper.insert(account)
        return account
    }

    override fun updateAccount(account: AccountEntity): AccountEntity {
        val recordCount = accountMapper.updateById(account)

        if (recordCount > 0) {
            return account
        } else {
            throw NoSuchElementException("没有id为: ${account.accountId} 的用户")
        }
    }

    override fun deleteAccount(accountId: Int) {
        val recordCount = accountMapper.deleteById(accountId)

        if (recordCount == 0) {
            throw NoSuchElementException("没有id为: $accountId 的用户")
        }
    }

    override fun findByName(name: String): Collection<AccountEntity> {
        return accountMapper.findByName(name)
    }
}
