package sam.sultan.data.pofile.dataSource

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProfileDao {
    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getProfile(): UserProfile
}