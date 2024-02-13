package sam.sultan.onlineCatalog.catalog.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feedback(
    val count: Int,
    val rating: Double
): Parcelable
