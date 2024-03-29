package br.com.fiap.mentorandoapp.dataBase.dao


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.mentorandoapp.model.AprendizModel

@Database(entities = [AprendizModel::class], version = 1)
abstract class AprendizDb : RoomDatabase() {

    abstract fun aprendizDao(): AprendizDao

    companion object {

        private lateinit var instance: AprendizDb

        fun getDatabase(context: Context): AprendizDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        AprendizDb::class.java,
                        "aprendiz_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}