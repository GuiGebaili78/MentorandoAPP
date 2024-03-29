package br.com.fiap.mentorandoapp.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.fiap.mentorandoapp.model.AprendizModel


@Dao
interface AprendizDao {
    @Insert
    fun salvar(aprendizModel: AprendizModel): Long
}









