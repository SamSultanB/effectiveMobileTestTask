package sam.sultan.onlineCatalog.favorite

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.favorite.repository.FavoritesRepository
import sam.sultan.onlineCatalog.favorite.presentation.FavoritesViewModel

val favoritesViewModule = module {
    viewModel { FavoritesViewModel(FavoritesRepository(androidContext())) }
}