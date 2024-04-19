/*
package br.com.fiap.mentorandoapp.Api

import android.util.Log
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.model.UsuarioModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray




suspend fun fetchUsuarioFromApi(): List<UsuarioModel> {
    return withContext(Dispatchers.IO) {
        try {
            val client = OkHttpClient.Builder().build()
            val request = Request.Builder()
                .url("https://660c75dd3a0766e85dbe2694.mockapi.io/api/v1/usuarioModel")
                .build()
            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()
            val jsonArray = JSONArray(responseBody)
            val usuarioList = mutableListOf<UsuarioModel>()
            for (i in 0 until jsonArray.length()) {
                val usuarioObject = jsonArray.getJSONObject(i)
                val usuario = UsuarioModel(
                    id = usuarioObject.getInt("id"),
                    nome = usuarioObject.getString("nome"),
                    formacao = usuarioObject.getString("formacao"),
                    experiencia = usuarioObject.getString("experiencia"),
                    interesse = usuarioObject.getString("interesse"),
                    objetivo = usuarioObject.getString("objetivo"),
                    disponibilidade = usuarioObject.getString("disponibilidade"),
                    localizacao = usuarioObject.getString("localizacao"),
                    contato = usuarioObject.getString("contato"),
                    tipo_usuario = usuarioObject.getString("tipo_usuario")
                )
                usuarioList.add(usuario)
            }
            // Obtendo a lista de uma chave
            val interesses = LocalStorage.getFilter("interesse")
            Log.d("UsuarioApi", "Usuários buscados: ${interesses.toString()}")
            usuarioList
        } catch (e: Exception) {
            Log.e("UsuarioApi", "Erro ao buscar usuários: ${e.message}")
            emptyList()
        }
    }
}

fun filtrarUsuario(usuariosApi: List<UsuarioModel>): List<UsuarioModel> {
    val filtroInteresse = LocalStorage.getFilter("interesse")
    val filtroTipoUsuario = LocalStorage.getFilter("tipo_usuario")
    val filtroLocalizacao = LocalStorage.getFilter("localizacao")
    val filtroDisponibilidade = LocalStorage.getFilter("disponibilidade")

    return usuariosApi.filter { usuario ->
        val interesseValido = filtroInteresse.isNullOrEmpty() || filtroInteresse.contains(usuario.interesse)
        val tipoUsuarioValido = filtroTipoUsuario.isNullOrEmpty() || filtroTipoUsuario.contains(usuario.tipo_usuario)
        val localizacaoValida = filtroLocalizacao.isNullOrEmpty() || filtroLocalizacao.contains(usuario.localizacao)
        val disponibilidadeValida = filtroDisponibilidade.isNullOrEmpty() || filtroDisponibilidade.contains(usuario.disponibilidade)

        interesseValido && tipoUsuarioValido && localizacaoValida && disponibilidadeValida
    }
}





*/


