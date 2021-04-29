package com.oasis.demo2.domain.dto

class AccountDTO {
    /**
     * 主键id
     */
    var accountId: Int? = null

    /**
     * 用户名
     */
    lateinit var accountName: String

    /**
     * 密码
     */
    lateinit var password: String
}