package sam.sultan.data.pofile.repository

import android.content.Context
import sam.sultan.data.common.db.AppDatabase

class ProfileRepository(val context: Context) {
    val profileDao = AppDatabase.getDatabase(context).profileDao()
    suspend fun getProfile() = profileDao.getProfile()
}