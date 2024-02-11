package sam.sultan.data.registration.repository

import sam.sultan.data.registration.local.RegistrationDao
import sam.sultan.data.registration.local.UserDto

class RegistrationRepository(val registrationDao: RegistrationDao) {

    suspend fun saveUser(userData: UserDto) = registrationDao.saveUser(userData)

//    suspend fun getUser() = registrationDao.getUser()

}