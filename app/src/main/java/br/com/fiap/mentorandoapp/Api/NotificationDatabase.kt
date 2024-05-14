package br.com.fiap.mentorandoapp.Api

import android.content.Context
import android.util.Log
import androidx.room.PrimaryKey
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.dataBase.repository.NotificationRepository
import br.com.fiap.mentorandoapp.dataBase.repository.UsuarioRepository
import br.com.fiap.mentorandoapp.model.NotificationModel
import br.com.fiap.mentorandoapp.model.UsuarioModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Função para buscar notificacoes
suspend fun fetchNotifications(context: Context, meuId: Int): List<NotificationModel> {
    return withContext(Dispatchers.IO) {
        try {
            val notificationRepository = NotificationRepository(context)
            val notifications = notificationRepository.listarNotificacoes(meuId)
            notifications
        } catch (e: Exception) {
            Log.e("NotificationDb", "Erro ao buscar notificacoes: ${e.message}")
            emptyList()
        }
    }
}