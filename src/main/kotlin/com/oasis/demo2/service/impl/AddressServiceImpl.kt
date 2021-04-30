package com.oasis.demo2.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.oasis.demo2.dao.AddressMapper
import com.oasis.demo2.domain.entity.AddressEntity
import com.oasis.demo2.service.IAddressService
import org.springframework.stereotype.Service

/**
 * <p>
 * 地址表 服务实现类
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-29
 */
@Service
class AddressServiceImpl(
    private val addressMapper: AddressMapper
) : ServiceImpl<AddressMapper, AddressEntity>(), IAddressService {

    override fun selectPageInfo(current: Long, pageSize: Long): Page<AddressEntity> {
        val page = Page<AddressEntity>(current, pageSize)
        return addressMapper.selectPageInfo(page)
    }

}
