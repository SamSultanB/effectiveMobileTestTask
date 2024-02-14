package sam.sultan.data.favorite.repository

import android.content.Context
import sam.sultan.data.common.db.AppDatabase

class FavoritesRepository(private val context: Context) {

    private val favoritesDao = AppDatabase.getDatabase(context).favoritesDao()

    suspend fun getAllProducts() = favoritesDao.getAllProducts()

}