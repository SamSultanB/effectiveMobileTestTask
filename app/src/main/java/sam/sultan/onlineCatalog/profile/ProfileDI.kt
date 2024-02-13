package sam.sultan.onlineCatalog.profile

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.pofile.repository.ProfileRepository
import sam.sultan.onlineCatalog.profile.presentation.ProfileViewModel

val profileViewModule = module {
    viewModel { ProfileViewModel(ProfileRepository(androidContext())) }
}