package sam.sultan.onlineCatalog.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.data.pofile.repository.ProfileRepository
import sam.sultan.onlineCatalog.profile.mapper.Profile
import sam.sultan.onlineCatalog.profile.mapper.ProfileMapper

class ProfileViewModel(val profileRepository: ProfileRepository): ViewModel() {

    private val mapper = ProfileMapper()

    val userProfileResponse: LiveData<Profile>
        get() = _userProfileResponse

    private val _userProfileResponse: MutableLiveData<Profile> = MutableLiveData()

    fun getProfile() = viewModelScope.launch {
        val profile = mapper.mapFromData(profileRepository.getProfile())
        _userProfileResponse.postValue(profile)
    }

}