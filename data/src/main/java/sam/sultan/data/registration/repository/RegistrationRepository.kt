package sam.sultan.data.registration.repository

import android.content.Context
import sam.sultan.data.common.db.AppDatabase
import sam.sultan.data.registration.local.RegistrationDao
import sam.sultan.data.registration.local.UserEntity

class RegistrationRepository(val context: Context) {

    val registrationDao = AppDatabase.getDatabase(context).registrationDao()

    suspend fun saveUser(userData: UserEntity) = registrationDao.saveUser(userData)

}