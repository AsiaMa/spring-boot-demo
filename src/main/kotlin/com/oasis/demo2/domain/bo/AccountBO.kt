package com.oasis.demo2.domain.bo

/**
 * @author AsiaMa
 * @since 2021-04-27
 */
class AccountBO {
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
