package sam.sultan.onlineCatalog.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.data.catalog.repository.CatalogRepository
import sam.sultan.onlineCatalog.catalog.mapper.CatalogMapper
import sam.sultan.onlineCatalog.catalog.model.ProductInfo

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
                    _catalogItemsResponse.postValue(response.body()
                        ?.let { mapper.mapFromDataList(it) })
                }
            }catch (e: Throwable){
                println("error")
            }
        }
    }

}