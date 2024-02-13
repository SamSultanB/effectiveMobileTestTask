package sam.sultan.data.catalog.dataSource.remote

import retrofit2.Response
import retrofit2.http.GET

interface CatalogApi {

    @GET("/v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getItems(): Response<ProductResponse>

}