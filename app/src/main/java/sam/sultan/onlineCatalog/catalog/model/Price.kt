package sam.sultan.onlineCatalog.catalog.model

data class Price(
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String
)
