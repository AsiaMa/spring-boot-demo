package com.oasis.demo2.controller

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

@SpringBootTest
@AutoConfigureMockMvc
internal class AccountControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    val baseUrl = "/api/accounts"

    @Nested
    @DisplayName("goAccounts()")
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
    @DisplayName("goAccount()")
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
    }

    @Test
    fun `should return Not Fount if the account id does not exist`() {
        // given
        val accountId = 1000

        // when/then
        mockMvc.get("$baseUrl/$accountId")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }
}