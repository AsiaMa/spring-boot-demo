package com.oasis.demo2.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.oasis.demo2.domain.entity.AccountEntity
import org.apache.ibatis.annotations.Mapper

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
@Mapper
interface AccountMapper : BaseMapper<AccountEntity> {

    fun findByName(name: String): Collection<AccountEntity>?
}
