package sam.sultan.data.catalog.dataSource.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CatalogDao {

    @Insert
    suspend fun saveProduct(productDB: ProductDB)

}