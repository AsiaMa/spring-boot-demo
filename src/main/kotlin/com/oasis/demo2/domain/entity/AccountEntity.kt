package com.oasis.demo2.domain.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
@TableName(value = "account")
data class AccountEntity(
    /**
     * 主键id
     */
    @TableId(value = "account_id", type = IdType.AUTO)
    val accountId: Int?,
    /**
     * 用户名
     */
    val accountName: String,
    /**
     * 密码
     */
    val password: String
)