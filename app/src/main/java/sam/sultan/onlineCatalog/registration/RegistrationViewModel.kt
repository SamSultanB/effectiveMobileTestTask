package sam.sultan.onlineCatalog.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.data.registration.repository.RegistrationRepository
import sam.sultan.onlineCatalog.registration.mapper.RegistrationMapper

class RegistrationViewModel(val registrationRepository: RegistrationRepository): ViewModel() {

    val mapper = RegistrationMapper()

    fun saveUser(userInfo: UserInfo){
        viewModelScope.launch {  registrationRepository.saveUser(mapper.mapToData(userInfo)) }
    }

}