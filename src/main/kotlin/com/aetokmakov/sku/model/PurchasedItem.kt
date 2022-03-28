package com.aetokmakov.sku.model

data class PurchasedItem(
    val version: Int,
    val edition: Char? = null,
    val quantity: Int
)
