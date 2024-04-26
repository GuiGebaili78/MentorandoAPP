package br.com.fiap.mentorandoapp.dataBase.dao




import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.mentorandoapp.model.MatchModel
import br.com.fiap.mentorandoapp.model.UsuarioModel


@Database(entities = [MatchModel::class], version = 2, exportSchema = true)
abstract class MatchDb : RoomDatabase() {

    abstract fun matchDao(): MatchDao

    companion object {

        private lateinit var instance: MatchDb

        fun getDatabase(context: Context): MatchDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        MatchDb::class.java,
                        "match_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}
