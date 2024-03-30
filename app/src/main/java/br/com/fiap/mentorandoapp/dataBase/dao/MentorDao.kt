package br.com.fiap.mentorandoapp.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.mentorandoapp.model.AprendizModel
import br.com.fiap.mentorandoapp.model.MentorModel


@Dao
interface MentorDao {
    @Insert
    fun salvar(mentorModel: MentorModel): Long

    @Query("SELECT * FROM tbl_mentor WHERE id = :id")
    fun buscarMentorModelPeloId(id: Int): MentorModel // Updated data type to Long

    @Query("SELECT * FROM tbl_mentor ORDER BY nome ASC")
    fun listarMentorModel(): List<MentorModel>
}
