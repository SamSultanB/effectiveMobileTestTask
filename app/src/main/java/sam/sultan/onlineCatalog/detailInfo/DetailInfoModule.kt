package sam.sultan.onlineCatalog.detailInfo

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.catalog.repository.CatalogRepository
import sam.sultan.data.detailInfo.repository.DetailInfoRepository
import sam.sultan.onlineCatalog.catalog.presentation.CatalogViewModel
import sam.sultan.onlineCatalog.detailInfo.presentation.DetailInfoViewModel


val detailInfoModule = module {
    viewModel { DetailInfoViewModel(DetailInfoRepository(androidContext())) }
}




