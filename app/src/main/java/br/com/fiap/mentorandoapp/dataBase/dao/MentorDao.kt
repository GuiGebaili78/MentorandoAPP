package br.com.fiap.mentorandoapp.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.fiap.mentorandoapp.model.AprendizModel
import br.com.fiap.mentorandoapp.model.MentorModel


@Dao
interface MentorDao {
    @Insert
    fun salvar(mentorModel: MentorModel): Long
}
