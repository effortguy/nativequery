package com.effortyguy.nativequery.dto

//interface NameOfAddress {
//    val name: String
//}

open class NameOfAddress(
    var NAME: String
) {
    constructor() : this(NAME = "")
}