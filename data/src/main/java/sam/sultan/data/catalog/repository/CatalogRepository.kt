package sam.sultan.data.catalog.repository

import android.content.Context
import sam.sultan.data.catalog.dataSource.local.ProductDB
import sam.sultan.data.common.db.AppDatabase
import sam.sultan.data.common.network.RetrofitInstance

class CatalogRepository(private val context: Context) {

    private val catalogDao = AppDatabase.getDatabase(context).catalogDao()
    suspend fun getAllItems() = RetrofitInstance.catalogApi.getItems()

    suspend fun saveProduct(productDB: ProductDB) = catalogDao.saveProduct(productDB)

}