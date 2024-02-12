package sam.sultan.data.common.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sam.sultan.data.pofile.dataSource.ProfileDao
import sam.sultan.data.registration.local.RegistrationDao
import sam.sultan.data.registration.local.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun registrationDao(): RegistrationDao
    abstract fun profileDao(): ProfileDao



    companion object{
        @Volatile
        private var INSTANCE: AppDatabase?= null
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "dataBase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}