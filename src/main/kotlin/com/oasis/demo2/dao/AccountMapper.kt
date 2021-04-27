package com.oasis.demo2.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.oasis.demo2.domain.entity.AccountEntity
import org.springframework.stereotype.Repository

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
@Repository
interface AccountMapper : BaseMapper<AccountEntity>
