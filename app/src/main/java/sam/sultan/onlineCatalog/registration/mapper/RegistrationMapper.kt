package sam.sultan.onlineCatalog.registration.mapper

import sam.sultan.data.registration.local.UserDto
import sam.sultan.onlineCatalog.registration.UserInfo

class RegistrationMapper {

    fun mapFromData(userDto: UserDto): UserInfo{
        return UserInfo(userDto.name, userDto.surname, userDto.phoneNumber)
    }

    fun mapToData(userInfo: UserInfo): UserDto{
        return UserDto(0, userInfo.name, userInfo.surname, userInfo.phoneNumber)
    }

    fun mapFromDataList(userDtos: List<UserDto>): List<UserInfo>{
        return userDtos.map { mapFromData(it) }
    }

    fun mapToDataList(userInfos: List<UserInfo>): List<UserDto>{
        return userInfos.map { mapToData(it) }
    }

}