package sam.sultan.onlineCatalog.registration

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.registration.repository.RegistrationRepository


val viewModule = module {
    viewModel { RegistrationViewModel(RegistrationRepository(androidContext())) }
}


