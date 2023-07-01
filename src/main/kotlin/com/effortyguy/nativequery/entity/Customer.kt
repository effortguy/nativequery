package com.effortyguy.nativequery.entity

import javax.persistence.*

@Entity
class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val addresses: List<Address>
)