import com.aetokmakov.sku.model.ProductMapping
import com.aetokmakov.sku.service.ProductAggregatorService

fun main(args: Array<String>) {
    val products = listOf("CVCD", "SDFD", "DDDF", "SDFD")
    val mappings = mapOf(
        "CVCD" to ProductMapping(1, 'X'),
        "SDFD" to ProductMapping(2, 'Z'),
        "DDDF" to ProductMapping(1)
    )

    val productAggregatorService = ProductAggregatorService()
    print(productAggregatorService.aggregate(products, mappings))
}
