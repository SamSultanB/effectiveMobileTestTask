package sam.sultan.onlineCatalog.catalog.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class ProductInfo(
    val title: String,
    val subtitle: String,
    val price: Price,
    val feedback: Feedback,
    val tags: List<String>,
    val available: Int,
    val description: String,
    val info: List<Info>,
    val ingredients: String
): Parcelable
