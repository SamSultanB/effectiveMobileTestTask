package sam.sultan.data.catalog

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductTable(
    @PrimaryKey
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
