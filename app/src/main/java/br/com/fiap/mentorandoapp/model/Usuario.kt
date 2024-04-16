package br.com.fiap.mentorandoapp.model

data class Usuario(
    val id: Int,
    val nome: String,
    val formacao: String,
    val interesse: String,
    val experiencia: String,
    val objetivo: String,
    val disponibilidade: String,
    val localizacao: String,
    val contato: String,
    val tipo_usuario: String

)