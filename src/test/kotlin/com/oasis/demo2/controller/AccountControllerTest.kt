package com.oasis.demo2.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.oasis.demo2.domain.entity.AccountEntity
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.patch
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class AccountControllerTest @Autowired constructor(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {

    val baseUrl = "/api/accounts"

    @Nested
    @DisplayName("GET /api/accounts")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAccounts {
        @Test
        fun `should return all banks`() {
            // when/then
            mockMvc.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].accountName") { value("Alice") }
                }

        }
    }

    @Nested
    @DisplayName("GEt /api/accounts/{accountId}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAccount {
        @Test
        fun `should return one bank with the given account id`() {
            val accountId = 1

            mockMvc.get("$baseUrl/$accountId")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountName") { value("AsiaMa") }
                }
        }

        @Test
        fun `should return Not Found if the account id does not exist`() {
            // given
            val accountId = 1000

            // when/then
            mockMvc.get("$baseUrl/$accountId")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
        }
    }

    @Nested
    @DisplayName("POST /api/accounts")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostNewAccount {
        @Test
        fun `should add the new account`() {
            // given
            val newAccount = AccountEntity(10, "bootstrap", "222")

            // when
            val preformPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newAccount)
            }

            // then
            preformPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(newAccount))
                    }
                    jsonPath("$.accountName") { value("bootstrap") }
                }

            mockMvc.get("$baseUrl/${newAccount.accountId}")
                .andExpect { content { json(objectMapper.writeValueAsString(newAccount)) } }
        }

        @Test
        fun `should return BAD REQUEST if account with given account id already exists`() {
            val invalidAccount = AccountEntity(10, "bootstrap", "222")

            // when
            val preformPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidAccount)
            }

            // then
            preformPost
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }
    }

    @Nested
    @DisplayName("PATCH /api/accounts")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PatchExistingAccount {

        @Test
        fun `should update an existing account`() {
            // given
            val updatedAccount = AccountEntity(11, "book", "abc123")

            // when
            val performPatchRequest = mockMvc.patch(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updatedAccount)
            }

            // then
            performPatchRequest
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(updatedAccount))
                    }
                }

            mockMvc.get("$baseUrl/${updatedAccount.accountId}")
                .andExpect { content { json(objectMapper.writeValueAsString(updatedAccount)) } }
        }

        @Test
        fun `should return Not Found if not account with given account id exists`() {
            // given
            val invalidAccount = AccountEntity(100, "近段时间", "qwe123")
            // when
            val performPatchRequest = mockMvc.patch(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidAccount)
            }
            // then
            performPatchRequest
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }
        }
    }
}