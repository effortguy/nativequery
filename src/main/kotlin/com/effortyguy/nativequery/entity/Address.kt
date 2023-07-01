package com.effortyguy.nativequery.entity

import javax.persistence.*

@Entity
class Address(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String,
    var phoneNum: String,
    var zipCode: String,
    var address1 : String,
    var address2: String
)