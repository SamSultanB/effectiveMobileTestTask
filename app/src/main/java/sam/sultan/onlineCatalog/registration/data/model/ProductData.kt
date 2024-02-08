package sam.sultan.onlineCatalog.registration.data.model

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

