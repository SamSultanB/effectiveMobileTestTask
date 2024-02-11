package sam.sultan.onlineCatalog.registration

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sam.sultan.data.common.db.AppDatabase
import sam.sultan.data.registration.repository.RegistrationRepository

val dbModule = module {
    single { AppDatabase.getDatabase(androidContext()) }
}
val repositoryModule = module {
    single { RegistrationRepository(get<AppDatabase>().registrationDao()) }
}
val viewModule = module {
    viewModel { RegistrationViewModel(get()) }
}

