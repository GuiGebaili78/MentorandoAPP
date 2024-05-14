package br.com.fiap.mentorandoapp.dataBase.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.mentorandoapp.model.MatchModel
import br.com.fiap.mentorandoapp.model.NotificationModel
import br.com.fiap.mentorandoapp.model.UsuarioModel

@Database(entities = [MatchModel::class, UsuarioModel::class, NotificationModel::class], version = 2, exportSchema = true)
abstract class DbConfig : RoomDatabase() {

    abstract fun matchDao(): MatchDao
    abstract fun usuarioDao(): UsuarioDao

    abstract fun notificationDao(): NotificationDao

    companion object {

        private lateinit var instance: DbConfig

        fun getDatabase(context: Context): DbConfig {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        DbConfig::class.java,
                        "mentorando_app"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}
