package sam.sultan.onlineCatalog.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.data.registration.repository.RegistrationRepository
import sam.sultan.onlineCatalog.registration.mapper.RegistrationMapper

class RegistrationViewModel(val registrationRepository: RegistrationRepository): ViewModel() {

    val mapper = RegistrationMapper()

    private val _registrationResponse: MutableLiveData<String> = MutableLiveData()
    val registrationResponse: LiveData<String>
        get() = _registrationResponse

    fun saveUser(userInfo: UserInfo){
        viewModelScope.launch {
            _registrationResponse.postValue(registrationRepository.saveUser(mapper.mapToData(userInfo)))
        }
    }

    fun fieldValidation(input: String): Boolean {
        val cyrillicPattern = Regex("[а-яёА-ЯЁ]+")
        return input.matches(cyrillicPattern)
    }

}