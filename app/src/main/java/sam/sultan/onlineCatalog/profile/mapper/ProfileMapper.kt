package sam.sultan.onlineCatalog.profile.mapper

import sam.sultan.data.pofile.dataSource.UserProfile

class ProfileMapper {

    fun mapFromData(userProfile: UserProfile): Profile {
        return Profile(userProfile.name, userProfile.surname, userProfile.phoneNumber)
    }

    fun mapToData(profile: Profile): UserProfile{
        return UserProfile(profile.name, profile.surname, profile.phoneNumber)
    }

    fun mapFromDataList(usersProfile: List<UserProfile>): List<Profile>{
        return  usersProfile.map { mapFromData(it) }
    }

    fun mapToDataList(profile: List<Profile>): List<UserProfile>{
        return profile.map { mapToData(it) }
    }

}