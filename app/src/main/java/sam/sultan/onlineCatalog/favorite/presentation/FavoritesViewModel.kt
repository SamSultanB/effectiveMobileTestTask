package sam.sultan.onlineCatalog.favorite.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.data.favorite.repository.FavoritesRepository
import sam.sultan.onlineCatalog.favorite.mapper.FavoriteProductInfo
import sam.sultan.onlineCatalog.favorite.mapper.FavoritesMapper

class FavoritesViewModel(private val favoritesRepository: FavoritesRepository): ViewModel() {

    private val mapper = FavoritesMapper()

    private val _favoritesResponse: MutableLiveData<List<FavoriteProductInfo>> = MutableLiveData()
    val favoritesResponse: LiveData<List<FavoriteProductInfo>> get() = _favoritesResponse

    fun getFavorites(){
        viewModelScope.launch {
            val favorites = favoritesRepository.getAllProducts()
            _favoritesResponse.postValue(mapper.mapFromDataList(favorites))
        }
    }

}