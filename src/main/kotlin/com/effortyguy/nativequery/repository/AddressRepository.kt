package com.effortyguy.nativequery.repository

import com.effortyguy.nativequery.dto.NameOfAddress
import com.effortyguy.nativequery.entity.Address
import com.effortyguy.nativequery.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AddressRepository : JpaRepository<Address, Long> {

    @Query(
        value = """
            SELECT name
            FROM address
            WHERE
                (:name is null or name = :name)
                and (:address1 is null or address1 = :address1)
                and (:address2 is null or address2 = :address2)
        """,
        nativeQuery = true
    )
    fun findByName(
        name: String? = null,
        address1: String? = null,
        address2: String? = null
    ): NameOfAddress
}

