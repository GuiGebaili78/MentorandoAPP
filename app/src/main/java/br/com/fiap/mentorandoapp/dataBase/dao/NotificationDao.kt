package br.com.fiap.mentorandoapp.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.mentorandoapp.model.NotificationModel
import br.com.fiap.mentorandoapp.model.UsuarioModel

@Dao
interface NotificationDao {
    @Insert
    fun salvar(notificationModel: NotificationModel): Long

    @Query("SELECT * FROM tbl_notification WHERE usuario_id = :id")
    fun listarNotificacoes(id: Int): List<NotificationModel>

}









