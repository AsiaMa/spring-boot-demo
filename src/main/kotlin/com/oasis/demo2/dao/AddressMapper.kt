package com.oasis.demo2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.oasis.demo2.domain.entity.AddressEntity
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

/**
 * <p>
 * 地址表 Mapper 接口
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-29
 */
@Mapper
interface AddressMapper : BaseMapper<AddressEntity> {
    fun selectLinkById(id: Int): AddressEntity

    fun selectPageInfo(@Param("page") page: Page<AddressEntity>): Page<AddressEntity>
}
