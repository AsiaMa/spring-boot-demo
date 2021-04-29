package com.oasis.demo2.mapper

import com.oasis.demo2.dao.AddressMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AddressMapperTest @Autowired constructor(private val addressMapper: AddressMapper) {

    @Nested
    @DisplayName("get address")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAddressById {

        @Test
        fun `should get address with given address id`() {
            // given
            val addressId = 1

            // when
            val address = addressMapper.selectLinkById(addressId)

            // then
            assertThat(address.id).isEqualTo(1)
        }
    }
}