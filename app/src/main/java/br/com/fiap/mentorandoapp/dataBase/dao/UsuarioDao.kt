package br.com.fiap.mentorandoapp.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.mentorandoapp.model.UsuarioModel

@Dao
interface UsuarioDao {
    @Insert
    fun salvar(usuarioModel: UsuarioModel): Long

    @Query("SELECT * FROM tbl_usuario WHERE id = :id")
    fun buscarUsuarioModelPeloId(id: Int): UsuarioModel

    @Query("SELECT * FROM tbl_usuario WHERE email = :email AND password = :password")
    fun usuarioLogin(email: String, password: String): UsuarioModel

    @Query("SELECT * FROM tbl_usuario ORDER BY nome ASC")
    fun listarUsuarioModel(): List<UsuarioModel>


}









