package br.com.fiap.mentorandoapp.model

data class Mentor(
    val id: Int,
    val nome: String,
    val formacao: String,
    val experiencia: String,
    val certificacao: String,
    val biografia: String,
    val disponibilidade: String,
    val localizacao: String,
    val contato: String
)