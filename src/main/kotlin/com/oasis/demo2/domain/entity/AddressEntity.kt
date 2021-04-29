package com.oasis.demo2.domain.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

/**
 * <p>
 * 地址表
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-29
 */
@TableName("address")
class AddressEntity : Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * 地址名
     */
    lateinit var addressName: String

    /**
     * 一个地址下的所有用户
     */
    @TableField(exist = false)
    var addressList: Collection<AccountEntity>? = null
}
