package com.oasis.demo2.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class AddressControllerTest @Autowired constructor(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {
    val baseUrl = "/api/address"

    @Nested
    @DisplayName("GET /api/address/page")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAccounts {

        @Test
        fun `should return address info of the current page`() {
            // given
            val current = 1
            val pageSize = 2

            // when / then
            mockMvc.get("$baseUrl/page?current=$current&pageSize=$pageSize")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                }.andExpect {
                    jsonPath("$.current") { value(1) }
                    jsonPath("$.records.size()") { value(pageSize) }
                }

        }
    }

}