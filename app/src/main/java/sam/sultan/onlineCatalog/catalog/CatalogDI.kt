package sam.sultan.onlineCatalog.catalog

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.catalog.repository.CatalogRepository
import sam.sultan.onlineCatalog.catalog.presentation.CatalogViewModel

val catalogModule = module {
    viewModel { CatalogViewModel(CatalogRepository(androidContext())) }
}