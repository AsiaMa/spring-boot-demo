package com.oasis.demo2.domain.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
@TableName(value = "account")
class AccountEntity : Serializable {
    /**
     * 主键id
     */
    @TableId(value = "account_id", type = IdType.AUTO)
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
        return "AccountEntity{" +
                "accountId=" + accountId +
                ", accountName=" + accountName +
                ", password=" + password +
                "}"
    }
}
