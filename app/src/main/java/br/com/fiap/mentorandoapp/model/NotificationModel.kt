package br.com.fiap.mentorandoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_notification")
data class NotificationModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var usuario_id: Int = 0,
    var nome: String = "",
    var contato: String = "",
)
