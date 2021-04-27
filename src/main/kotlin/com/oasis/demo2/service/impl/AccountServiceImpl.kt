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
}
