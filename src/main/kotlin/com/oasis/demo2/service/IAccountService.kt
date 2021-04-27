package com.oasis.demo2.service

import com.baomidou.mybatisplus.extension.service.IService
import com.oasis.demo2.domain.entity.AccountEntity

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
interface IAccountService : IService<AccountEntity> {
    /**
     * 根据用户id查询
     */
    fun findById(accountId: Int): AccountEntity

    /**
     * 查询所有用户
     */
    fun getAccounts(): Collection<AccountEntity>
}
