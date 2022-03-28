package com.aetokmakov.sku.service

import com.aetokmakov.sku.exception.ProductListIsEmptyException
import com.aetokmakov.sku.test.productMapping
import com.aetokmakov.sku.test.purchasedItem
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ProductAggregatorServiceTest {

    private lateinit var productAggregatorService: ProductAggregatorService

    @BeforeEach
    fun setup() {
        productAggregatorService = ProductAggregatorService()
    }

    @Test
    fun `aggregate - happy path`() {
        val products = listOf("CVCD", "SDFD", "DDDF", "SDFD")
        val mappings = mapOf(
            "CVCD" to productMapping(edition = 'X'),
            "SDFD" to productMapping(version = 2, edition = 'Z'),
            "DDDF" to productMapping()
        )

        val result = productAggregatorService.aggregate(products, mappings)

        val expectedResult = listOf(
            purchasedItem(edition = 'X'),
            purchasedItem(version = 2, edition = 'Z', quantity = 2),
            purchasedItem()
        )

        assertEquals(expectedResult, result)
    }

    @Test
    fun `aggregate - product list is empty exception`() {
        val products = emptyList<String>()
        val mappings = mapOf("CVCD" to productMapping(edition = 'X'))

        assertThrows<ProductListIsEmptyException>{
            productAggregatorService.aggregate(products, mappings)
        }.also {
            assertEquals("Product list is empty", it.message)
            assertNull(it.cause)
        }
    }

    @Test
    fun `aggregate - mapping list is empty`() {
        val products = listOf("CVCD", "SDFD", "DDDF", "SDFD")

        val result = productAggregatorService.aggregate(products, emptyMap())

        assertTrue(result.isEmpty())
    }
}
