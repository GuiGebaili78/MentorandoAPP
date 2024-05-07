package br.com.fiap.mentorandoapp.dataBase.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.mentorandoapp.model.UsuarioModel

@Database(entities = [UsuarioModel::class], version = 2, exportSchema = true)
abstract class UsuarioDb : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    companion object {

        private lateinit var instance: UsuarioDb

        fun getDatabase(context: Context): UsuarioDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        UsuarioDb::class.java,
                        "usuario_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}
