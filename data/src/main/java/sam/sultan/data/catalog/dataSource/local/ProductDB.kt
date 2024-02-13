package sam.sultan.data.catalog.dataSource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("products")
data class ProductDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val subtitle: String,
    //price part
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String,
    //feedback
    val count: Int,
    val rating: Double
)
