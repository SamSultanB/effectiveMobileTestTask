package sam.sultan.data.catalog.dataSource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("products")
data class ProductDB(
    @PrimaryKey
    val id: Int,
    val title: String,
    val subtitle: String,
    val tags: String,
    val available: Int,
    val description: String,
    val info: String,
    val ingredients: String,
    //price part
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String,
    //feedback
    val count: Int,
    val rating: Double
)
