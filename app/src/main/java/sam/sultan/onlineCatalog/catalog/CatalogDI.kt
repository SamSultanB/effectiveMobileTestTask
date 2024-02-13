package sam.sultan.onlineCatalog.catalog

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.catalog.repository.CatalogRepository

val catalogModule = module {
    viewModel { CatalogViewModel(CatalogRepository()) }
}