package sam.sultan.data.common.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sam.sultan.data.catalog.dataSource.remote.CatalogApi

class RetrofitInstance {

    companion object{
        private val retrofit by lazy{
            Retrofit.Builder().baseUrl("https://run.mocky.io/").addConverterFactory(GsonConverterFactory.create()).build()
        }

        val catalogApi by lazy { retrofit.create(CatalogApi::class.java) }
    }

}