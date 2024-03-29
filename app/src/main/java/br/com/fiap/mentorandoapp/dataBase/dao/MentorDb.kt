package br.com.fiap.mentorandoapp.dataBase.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.mentorandoapp.model.AprendizModel
import br.com.fiap.mentorandoapp.model.MentorModel

@Database(entities = [MentorModel::class], version = 1)
abstract class MentorDb : RoomDatabase() {

    abstract fun mentorDao(): MentorDao

    companion object {

        private lateinit var instance: MentorDb

        fun getDatabase(context: Context): MentorDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        MentorDb::class.java,
                        "mentor_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}