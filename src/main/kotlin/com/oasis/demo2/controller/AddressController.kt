package com.oasis.demo2.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.oasis.demo2.domain.entity.AddressEntity
import com.oasis.demo2.service.IAddressService
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 地址表 前端控制器
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-29
 */
@RestController
@RequestMapping("/api/address")
class AddressController(private val addressService: IAddressService) {

    @RequestMapping("/page")
    fun selectPageInfo(
        @RequestParam(defaultValue = "1") current: Long,
        @RequestParam(defaultValue = "2") pageSize: Long
    ): Page<AddressEntity> = addressService.selectPageInfo(current, pageSize)
}
