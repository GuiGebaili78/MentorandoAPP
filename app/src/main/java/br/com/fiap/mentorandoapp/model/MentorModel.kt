package br.com.fiap.mentorandoapp.model

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_mentor")
data class MentorModel (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var nome: String = "",
    var certificacao: String = "",
    var formacao: String = "",
    var atuacao: String = "",
    var biografia: String = "",
    var disponibilidade: String = "",
    var localizacao: String = "",
    var contato: String = ""

)
