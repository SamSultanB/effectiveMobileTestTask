package sam.sultan.onlineCatalog.catalog.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.data.catalog.repository.CatalogRepository
import sam.sultan.onlineCatalog.catalog.mapper.CatalogMapper
import sam.sultan.onlineCatalog.catalog.model.ProductInfo
import java.io.IOException

class CatalogViewModel(private val catalogRepository: CatalogRepository): ViewModel() {

    private val mapper = CatalogMapper()

    private val _catalogItemsResponse: MutableLiveData<List<ProductInfo>> = MutableLiveData()

    val catalogItemsResponse: LiveData<List<ProductInfo>>
        get() = _catalogItemsResponse


    fun getProducts(){
        viewModelScope.launch {
            try {
                val response = catalogRepository.getAllItems()
                if(response.isSuccessful){
                    if(response.body() != null){
                        _catalogItemsResponse.postValue(response.body()
                            ?.let { mapper.mapFromDataList(it.items) })
                    }else{
                        println("Body is null")
                    }
                }else{
                    println("network error first: ${response.errorBody()?.toString()}")
                }
            } catch (e: IOException) {
                println("Network error: ${e.message}")
                // Handle network-related exception (e.g., show error message to the user)
            } catch (e: Throwable) {
                println("Unknown error: ${e.message}")
                // Handle other types of exceptions (e.g., show error message to the user)
            }
        }
    }

    fun save(productInfo: ProductInfo){
        viewModelScope.launch {
            catalogRepository.saveProduct(mapper.mapToData(productInfo))
        }
    }

}