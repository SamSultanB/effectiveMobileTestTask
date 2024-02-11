package sam.sultan.onlineCatalog.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sam.sultan.onlineCatalog.registration.dbModule
import sam.sultan.onlineCatalog.registration.repositoryModule
import sam.sultan.onlineCatalog.registration.viewModule

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin() {
            modules(
                listOf(
                    dbModule,
                    repositoryModule,
                    viewModule
                )
            )
            androidContext(this@Application)
        }
    }
}