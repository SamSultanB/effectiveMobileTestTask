package sam.sultan.onlineCatalog.catalog.mapper

import sam.sultan.data.catalog.dataSource.local.ProductDB
import sam.sultan.data.catalog.dataSource.remote.Product
import sam.sultan.onlineCatalog.catalog.model.Feedback
import sam.sultan.onlineCatalog.catalog.model.Info
import sam.sultan.onlineCatalog.catalog.model.Price
import sam.sultan.onlineCatalog.catalog.model.ProductInfo


class CatalogMapper {

    fun mapFromData(product: Product): ProductInfo{
        return ProductInfo(product.title, product.subtitle,
        Price(product.price.price+product.price.unit, product.price.discount, product.price.priceWithDiscount+product.price.unit, product.price.unit),
            Feedback(product.feedback.count, product.feedback.rating),
            product.tags,
            product.available,
            product.description,
            product.info.map { Info(it.title, it.value) },
            product.ingredients
            )
    }

    fun mapToData(productInfo: ProductInfo): ProductDB{
        return ProductDB(0, productInfo.title, productInfo.subtitle,
            productInfo.tags.toString(), productInfo.available,
            productInfo.description, "info", productInfo.ingredients,
            productInfo.price.price, productInfo.price.discount, productInfo.price.priceWithDiscount, productInfo.price.unit,
            productInfo.feedback.count,
            productInfo.feedback.rating)
    }

    fun mapFromDataList(products: List<Product>): List<ProductInfo> {
        return products.map { mapFromData(it) }
    }

    fun mapToDataList(productInfos: List<ProductInfo>): List<ProductDB>{
        return productInfos.map { mapToData(it) }
    }

}