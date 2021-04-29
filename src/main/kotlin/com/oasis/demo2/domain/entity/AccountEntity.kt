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
class AccountEntity() {
    /**
     * 主键id
     */
    @TableId(value = "account_id", type = IdType.AUTO)
    var accountId: Int? = null

    /**
     * 用户名
     */
    lateinit var accountName: String

    /**
     * 密码
     */
    lateinit var password: String

    var addressId: Int? = null

    lateinit var address: AddressEntity

    constructor(accountId: Int, accountName: String, password: String, addressId: Int) : this() {
        this.accountId = accountId
        this.accountName = accountName
        this.password = password
        this.addressId = addressId
    }
}