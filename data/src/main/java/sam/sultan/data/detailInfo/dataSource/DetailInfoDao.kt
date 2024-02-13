package sam.sultan.data.detailInfo.dataSource

import androidx.room.Dao
import androidx.room.Insert
import sam.sultan.data.catalog.dataSource.local.ProductDB

@Dao
interface DetailInfoDao {

    @Insert
    suspend fun saveProduct(productDB: ProductDB)

}