package sam.sultan.onlineCatalog.favorite.mapper

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteProductInfo(
    val id: Int,
    val title: String,
    val subtitle: String,
    //price part
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    //feedback
    val count: Int,
    val rating: Double
): Parcelable
