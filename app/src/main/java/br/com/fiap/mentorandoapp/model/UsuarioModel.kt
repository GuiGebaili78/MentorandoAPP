package br.com.fiap.mentorandoapp.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_usuario")
data class UsuarioModel (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var nome: String = "",
    var interesse: String = "",
    var formacao: String = "",
    var experiencia: String = "",
    var objetivo: String = "",
    var disponibilidade: String = "",
    var localizacao: String = "",
    var contato: String = "",
    var tipo_usuario: String = ""


)
