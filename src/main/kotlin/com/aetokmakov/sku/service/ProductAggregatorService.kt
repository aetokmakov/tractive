package com.aetokmakov.sku.service

import com.aetokmakov.sku.exception.ProductListIsEmptyException
import com.aetokmakov.sku.model.ProductMapping
import com.aetokmakov.sku.model.PurchasedItem

class ProductAggregatorService {

    fun aggregate(products: List<String>, mappings: Map<String, ProductMapping>): List<PurchasedItem> {
        if (products.isEmpty()) {
            throw ProductListIsEmptyException()
        }

        return mappings.filter { productMapping -> products.contains(productMapping.key) }
            .map { (key, value) ->
                PurchasedItem(
                    version = value.version,
                    edition = value.edition,
                    quantity = products.count { product -> product == key }
                )
            }
    }
}
