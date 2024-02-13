package sam.sultan.onlineCatalog.detailInfo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.data.detailInfo.repository.DetailInfoRepository
import sam.sultan.onlineCatalog.catalog.model.ProductInfo
import sam.sultan.onlineCatalog.detailInfo.mapper.DetailInfoMapper

class DetailInfoViewModel(private val detailInfoRepository: DetailInfoRepository): ViewModel() {

    private val mapper = DetailInfoMapper()

    fun save(productInfo: ProductInfo){
        viewModelScope.launch {
            detailInfoRepository.saveProduct(mapper.mapToData(productInfo))
        }
    }


}