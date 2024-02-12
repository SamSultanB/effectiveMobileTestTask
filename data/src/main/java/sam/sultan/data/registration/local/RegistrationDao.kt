package sam.sultan.data.registration.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface RegistrationDao {

    @Insert
    suspend fun saveUser(userEntity: UserEntity)


}