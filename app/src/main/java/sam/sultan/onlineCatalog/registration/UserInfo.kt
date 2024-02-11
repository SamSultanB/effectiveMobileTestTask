package sam.sultan.onlineCatalog.registration

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(
    val name: String,
    val surname: String,
    val phoneNumber: String
) : Parcelable
