package com.aetokmakov.sku.test

import com.aetokmakov.sku.model.ProductMapping
import com.aetokmakov.sku.model.PurchasedItem

fun productMapping(
    version: Int = 1,
    edition: Char? = null
) = ProductMapping(
    version = version,
    edition = edition
)

fun purchasedItem(
    version: Int = 1,
    edition: Char? = null,
    quantity: Int = 1
) = PurchasedItem(
    version = version,
    edition = edition,
    quantity = quantity
)
