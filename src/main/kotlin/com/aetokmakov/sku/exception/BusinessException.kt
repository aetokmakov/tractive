package com.aetokmakov.sku.exception

class ProductListIsEmptyException(
    cause: Throwable? = null
) : RuntimeException("Product list is empty", cause)
