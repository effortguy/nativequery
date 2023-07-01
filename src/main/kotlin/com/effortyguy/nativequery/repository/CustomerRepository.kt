package com.effortyguy.nativequery.repository

import com.effortyguy.nativequery.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>