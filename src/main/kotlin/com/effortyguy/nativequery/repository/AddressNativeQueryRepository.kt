package com.effortyguy.nativequery.repository

import com.effortyguy.nativequery.dto.NameOfAddress
import com.effortyguy.nativequery.entity.Address
import org.hibernate.query.NativeQuery
import org.hibernate.transform.Transformers
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class AddressNativeQueryRepository(
    private val entityManager: EntityManager
) {

//    fun findByName(
//        name: String? = null,
//    ): Address {
//        val query = """
//            SELECT *
//            FROM address
//            WHERE name = :name
//        """.trimIndent()
//
//        return entityManager.createNativeQuery(query, Address::class.java)
//            .setParameter("name", name)
//            .resultList
//            .first() as Address
//    }

    fun findByName(
        name: String? = null,
    ): NameOfAddress {
        val query = """
            SELECT name
            FROM address
            WHERE name = :name
        """.trimIndent()

        return entityManager.createNativeQuery(query)
            .setParameter("name", name)
            .unwrap(NativeQuery::class.java)
            .setResultTransformer(Transformers.aliasToBean(NameOfAddress::class.java))
            .resultList
            .first() as NameOfAddress
    }
}