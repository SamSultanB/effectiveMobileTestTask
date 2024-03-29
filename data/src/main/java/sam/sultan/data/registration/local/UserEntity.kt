package sam.sultan.data.registration.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String
)
