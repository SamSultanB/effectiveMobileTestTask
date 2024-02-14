package sam.sultan.data.common.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sam.sultan.data.catalog.dataSource.local.CatalogDao
import sam.sultan.data.catalog.dataSource.local.ProductDB
import sam.sultan.data.detailInfo.dataSource.DetailInfoDao
import sam.sultan.data.favorite.dataSource.FavoritesDao
import sam.sultan.data.pofile.dataSource.ProfileDao
import sam.sultan.data.registration.local.RegistrationDao
import sam.sultan.data.registration.local.UserEntity

@Database(entities = [UserEntity::class, ProductDB::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun registrationDao(): RegistrationDao
    abstract fun profileDao(): ProfileDao
    abstract fun catalogDao(): CatalogDao
    abstract fun detailInfoDao(): DetailInfoDao
    abstract fun favoritesDao(): FavoritesDao



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