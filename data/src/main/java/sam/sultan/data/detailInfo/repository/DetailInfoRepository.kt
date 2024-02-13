package sam.sultan.data.detailInfo.repository

import android.content.Context
import sam.sultan.data.catalog.dataSource.local.ProductDB

import sam.sultan.data.common.db.AppDatabase

class DetailInfoRepository(private val context: Context) {

    private val catalogDao = AppDatabase.getDatabase(context).detailInfoDao()

    suspend fun saveProduct(productDB: ProductDB) = catalogDao.saveProduct(productDB)

}