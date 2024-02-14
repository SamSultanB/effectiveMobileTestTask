package sam.sultan.data.favorite.dataSource

data class FavoriteProduct(
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
