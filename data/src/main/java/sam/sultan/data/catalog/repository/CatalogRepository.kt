package sam.sultan.data.catalog.repository

import sam.sultan.data.common.network.RetrofitInstance

class CatalogRepository {

    suspend fun getAllItems() = RetrofitInstance.catalogApi.getItems()

}