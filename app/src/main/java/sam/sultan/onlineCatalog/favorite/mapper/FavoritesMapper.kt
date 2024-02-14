package sam.sultan.onlineCatalog.favorite.mapper

import sam.sultan.data.favorite.dataSource.FavoriteProduct

class FavoritesMapper {

    fun mapFromData(favoriteProduct: FavoriteProduct): FavoriteProductInfo {
        return FavoriteProductInfo(favoriteProduct.id, favoriteProduct.title, favoriteProduct.subtitle,
            favoriteProduct.price + favoriteProduct.unit, favoriteProduct.discount,
            favoriteProduct.priceWithDiscount + favoriteProduct.unit,
            favoriteProduct.count, favoriteProduct.rating)
    }

    fun mapFromDataList(favorites: List<FavoriteProduct>): List<FavoriteProductInfo>{
        return  favorites.map { mapFromData(it) }
    }

}