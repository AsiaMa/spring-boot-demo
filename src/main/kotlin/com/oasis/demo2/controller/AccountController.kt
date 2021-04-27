package com.oasis.demo2.controller


import com.oasis.demo2.domain.entity.AccountEntity
import com.oasis.demo2.service.IAccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
@RestController
@RequestMapping("api/accounts")
class AccountController(private val accountService: IAccountService) {

    @GetMapping
    fun getAccount(): Collection<AccountEntity> = accountService.getAccounts()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") accountId: Int) {
        val account = accountService.findById(accountId)
        println(account)
    }
}
