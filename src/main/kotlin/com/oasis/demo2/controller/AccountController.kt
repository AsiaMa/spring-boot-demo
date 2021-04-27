package com.oasis.demo2.controller


import com.oasis.demo2.domain.entity.AccountEntity
import com.oasis.demo2.service.IAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author AsiaMa
 * @since 2021-04-27
 */
@RestController
@RequestMapping("/api/accounts")
class AccountController(private val accountService: IAccountService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getAccount(): Collection<AccountEntity> = accountService.getAccounts()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") accountId: Int) = accountService.findById(accountId)
}
