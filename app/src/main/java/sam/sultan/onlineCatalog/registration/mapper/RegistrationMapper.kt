package sam.sultan.onlineCatalog.registration.mapper

import sam.sultan.data.registration.local.UserEntity
import sam.sultan.onlineCatalog.registration.presentation.UserInfo

class RegistrationMapper {

    fun mapFromData(userEntity: UserEntity): UserInfo {
        return UserInfo(userEntity.name, userEntity.surname, userEntity.phoneNumber)
    }

    fun mapToData(userInfo: UserInfo): UserEntity{
        return UserEntity(0, userInfo.name, userInfo.surname, userInfo.phoneNumber)
    }

    fun mapFromDataList(userEntities: List<UserEntity>): List<UserInfo>{
        return userEntities.map { mapFromData(it) }
    }

    fun mapToDataList(userInfos: List<UserInfo>): List<UserEntity>{
        return userInfos.map { mapToData(it) }
    }

}