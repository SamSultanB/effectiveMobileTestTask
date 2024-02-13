package sam.sultan.onlineCatalog.registration.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(
    val name: String,
    val surname: String,
    val phoneNumber: String
) : Parcelable
