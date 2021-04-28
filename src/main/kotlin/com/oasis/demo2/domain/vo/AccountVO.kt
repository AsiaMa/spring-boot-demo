package com.oasis.demo2.domain.vo

class AccountVO {
    /**
     * 主键id
     */
    var accountId: Int? = null

    /**
     * 用户名
     */
    var accountName: String? = null


    override fun toString(): String {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName=" + accountName +
                "}"
    }
}