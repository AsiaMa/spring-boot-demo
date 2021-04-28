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
    var accountName: String? = null

    /**
     * 密码
     */
    var password: String? = null


    override fun toString(): String {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName=" + accountName +
                ", password=" + password +
                "}"
    }
}
