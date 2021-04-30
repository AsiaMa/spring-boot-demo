package com.oasis.demo2.mapper

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.oasis.demo2.dao.AddressMapper
import com.oasis.demo2.domain.entity.AddressEntity
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
        fun `should return an address with the given address id`() {
            // given
            val addressId = 1

            // when
            val address = addressMapper.selectLinkById(addressId)

            // then
            assertThat(address.id).isEqualTo(1)
        }

        @Test
        fun `should return no address if the given address id does not exists`() {
            // given
            val invalidAddressId = -1

            // when
            val address = addressMapper.selectLinkById(invalidAddressId)

            // then
            assertThat(address).isNull()
        }
    }

    @Nested
    @DisplayName("get page address")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetPageAddress {

        @Test
        fun `should return page info for address`() {
            val page = Page<AddressEntity>(1, 2)
            // when
            val pageInfo = addressMapper.selectPageInfo(page)

            // then
            assertThat(pageInfo.size).isEqualTo(2)
            assertThat(pageInfo.current).isEqualTo(1)
            assertThat(pageInfo.records.size).isEqualTo(2)
        }
    }
}