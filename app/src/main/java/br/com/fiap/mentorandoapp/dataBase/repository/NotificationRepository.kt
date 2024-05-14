package br.com.fiap.mentorandoapp.dataBase.repository

import android.content.Context
import br.com.fiap.mentorandoapp.dataBase.dao.DbConfig
import br.com.fiap.mentorandoapp.model.MatchModel
import br.com.fiap.mentorandoapp.model.NotificationModel

class NotificationRepository(context: Context) {

    private val db = DbConfig.getDatabase(context).notificationDao()

    fun salvar(notificationModel: NotificationModel): Long {
        return db.salvar(notificationModel)
    }

    fun listarNotificacoes(id: Int): List<NotificationModel> {
        return db.listarNotificacoes(id)
    }
}

