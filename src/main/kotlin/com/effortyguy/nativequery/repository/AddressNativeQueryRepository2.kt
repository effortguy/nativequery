//package com.effortyguy.nativequery.repository
//
//import com.effortyguy.nativequery.dto.NameOfAddress
//import org.hibernate.query.NativeQuery
//import org.hibernate.transform.Transformers
//import org.springframework.stereotype.Repository
//import javax.persistence.EntityManager
//
//@Repository
//class AddressNativeQueryRepository(
//    private val entityManager: EntityManager
//) {
//
//    fun findByName(
//        name: String? = null,
//        address1: String? = null,
//        address2: String? = null
//    ): NameOfAddress {
//
//        val query = createQuery(
//            name = name,
//            address1 = address1,
//            address2 = address2
//        )
//
//        return entityManager.createNativeQuery(query)
//            .unwrap(NativeQuery::class.java)
//            .setResultTransformer(Transformers.aliasToBean(NameOfAddress::class.java))
//            .resultList
//            .first() as NameOfAddress
//    }
//
//    private fun createQuery(
//        name: String?,
//        address1: String?,
//        address2: String?
//    ) = """
//            SELECT name
//            FROM address
//            ${
//                createWhere(
//                    name = name,
//                    address1 = address1,
//                    address2 = address2
//                )
//            }
//    """.trimIndent()
//
//    private fun createWhere(
//        name: String?,
//        address1: String?,
//        address2: String?
//    ) = listOfNotNull(
//        "name".eq(name),
//        "address1".eq(address1),
//        "address2".eq(address2)
//    ).toWhere()
//}
//
//private fun String.eq(string: String?) = string?.let { "$this = '$string'" }
//private fun List<String>.toWhere() = "WHERE ${this.joinToString(" and ")}"