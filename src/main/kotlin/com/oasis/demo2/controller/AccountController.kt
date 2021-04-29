package com.oasis.demo2.controller


import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.oasis.demo2.domain.entity.AccountEntity
import com.oasis.demo2.domain.vo.AccountVO
import com.oasis.demo2.service.IAccountService
import org.springframework.beans.BeanUtils
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

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getAccount(): Collection<AccountEntity> = accountService.getAccounts()

    @GetMapping("/pagination")
    fun getAccountsByPage(
        @RequestParam(defaultValue = "1") current: Long,
        @RequestParam(defaultValue = "2") pageSize: Long
    ): Page<AccountEntity> =
        accountService.getAccountsByPage(current, pageSize)

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") accountId: Int): AccountVO {
        val accountVO = AccountVO()
        val accountBO = accountService.findById(accountId)
        BeanUtils.copyProperties(accountBO, accountVO)
        return accountVO
    }

    @GetMapping("/name/{name}")
    fun findByName(@PathVariable name: String) = accountService.findByName(name)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addAccount(@RequestBody account: AccountEntity): AccountEntity = accountService.addAccount(account)

    @PatchMapping
    fun updateAccount(@RequestBody account: AccountEntity): AccountEntity = accountService.updateAccount(account)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAccount(@PathVariable("id") accountId: Int): Unit = accountService.deleteAccount(accountId)
}
