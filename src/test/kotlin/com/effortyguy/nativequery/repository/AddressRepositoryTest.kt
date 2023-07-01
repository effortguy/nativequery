package com.effortyguy.nativequery.repository

import com.effortyguy.nativequery.entity.Address
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
class AddressRepositoryTest(
    @Autowired
    private val addressRepository: AddressRepository,
    @Autowired
    private val addressNativeQueryRepository: AddressNativeQueryRepository
) {

    @BeforeEach
    fun beforeEach() {
        val address = Address(
            id = 0,
            name = "effortguy",
            phoneNum = "01012345678",
            zipCode = "12345",
            address1 = "address1",
            address2 = "address2"
        )
        addressRepository.save(address)
    }

    @Transactional
    @Test
    fun test() {
        val address = addressNativeQueryRepository.findByName(name = "effortguy")

        println(address.NAME)
    }
}
