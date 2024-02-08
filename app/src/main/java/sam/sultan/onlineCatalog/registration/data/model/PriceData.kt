package sam.sultan.onlineCatalog.registration.data.model

data class PriceData(
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String
)
