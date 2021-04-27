package com.oasis.demo2.domain.bo

/**
 * @author AsiaMa
 * @since 2021-04-27
 */
class AccountBO {
    var accountId: Int? = null

    var accountName: String? = null

    var password: String? = null

    override fun toString(): String {
        return "Account{" +
        "accountId=" + accountId +
        ", accountName=" + accountName +
        ", password=" + password +
        "}"
    }
}
