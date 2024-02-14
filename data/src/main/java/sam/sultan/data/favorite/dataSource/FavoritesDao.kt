package sam.sultan.data.favorite.dataSource

import androidx.room.Dao
import androidx.room.Query

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<FavoriteProduct>

}