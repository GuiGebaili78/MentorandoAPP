package br.com.fiap.mentorandoapp.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.mentorandoapp.model.AprendizModel


@Dao
interface AprendizDao {
    @Insert
    fun salvar(aprendizModel: AprendizModel): Long

    @Query("SELECT * FROM tbl_aprendiz WHERE id = :id")
    fun buscarAprendizModelPeloId(id: Int): AprendizModel // Updated data type to Long

    @Query("SELECT * FROM tbl_aprendiz ORDER BY nome ASC")
    fun listarAprendizModel(): List<AprendizModel>
}









