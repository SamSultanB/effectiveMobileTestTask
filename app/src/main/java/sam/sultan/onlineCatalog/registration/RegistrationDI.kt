package sam.sultan.onlineCatalog.registration

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.registration.repository.RegistrationRepository
import sam.sultan.onlineCatalog.registration.presentation.RegistrationViewModel


val viewModule = module {
    viewModel { RegistrationViewModel(RegistrationRepository(androidContext())) }
}


