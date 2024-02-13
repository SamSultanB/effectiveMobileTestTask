package sam.sultan.data.registration.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegistrationDao {

    @Insert
    suspend fun saveUser(userEntity: UserEntity)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): UserEntity

}