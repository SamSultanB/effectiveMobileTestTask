package sam.sultan.data.catalog.dataSource.remote

data class Product(
    val id: String,
    val title: String,
    val subtitle: String,
    val price: PriceData,
    val feedback: FeedbackData,
    val tags: List<String>,
    val available: Int,
    val description: String,
    val info: List<InfoData>,
    val ingredients: String
)

data class FeedbackData(
    val count: Int,
    val rating: Double
)

data class InfoData(
    val title: String,
    val value: String
)

data class PriceData(
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String
)
