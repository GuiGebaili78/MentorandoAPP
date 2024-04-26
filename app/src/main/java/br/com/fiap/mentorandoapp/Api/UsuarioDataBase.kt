package br.com.fiap.mentorandoapp.Api

import android.content.Context
import android.util.Log
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.dataBase.repository.UsuarioRepository
import br.com.fiap.mentorandoapp.model.UsuarioModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


// Função para buscar os usuários no banco de dados local com aplicação de filtros
suspend fun fetchUsuariosFromDb(context: Context): List<UsuarioModel> {
    return withContext(Dispatchers.IO) {
        try {
            val usuarioRepository = UsuarioRepository(context)
            val usuario = usuarioRepository.listarUsuarioModel()

            // Aplicar filtros
            val filtroInteresse = LocalStorage.getFilter("interesse")
            val filtroTipoUsuario = LocalStorage.getFilter("tipo_usuario")
            val filtroLocalizacao = LocalStorage.getFilter("localizacao")
            val filtroDisponibilidade = LocalStorage.getFilter("disponibilidade")
            val filtroMeusMatchs = LocalStorage.getFilter("meus_matchs")

            usuario.filter { usuario ->
                val interesseValido = filtroInteresse.isNullOrEmpty() || filtroInteresse.contains(usuario.interesse)
                val tipoUsuarioValido = filtroTipoUsuario.isNullOrEmpty() || filtroTipoUsuario.contains(usuario.tipo_usuario)
                val localizacaoValida = filtroLocalizacao.isNullOrEmpty() || filtroLocalizacao.contains(usuario.localizacao)
                val disponibilidadeValida = filtroDisponibilidade.isNullOrEmpty() || filtroDisponibilidade.contains(usuario.disponibilidade)

                val naoEstaNosMeusMatchs = filtroMeusMatchs.isNullOrEmpty() || !filtroMeusMatchs.contains(usuario.id.toString())

                interesseValido && tipoUsuarioValido && localizacaoValida && disponibilidadeValida && naoEstaNosMeusMatchs
            }
        } catch (e: Exception) {
            Log.e("UsuarioDb", "Erro ao buscar usuários no banco de dados: ${e.message}")
            emptyList()
        }
    }
}
// Função para filtrar os usuários (mantida para aplicar filtros se necessário)
fun filtrarUsuario(usuarioDb: List<UsuarioModel>): List<UsuarioModel> {
    val filtroInteresse = LocalStorage.getFilter("interesse")
    val filtroLocalizacao = LocalStorage.getFilter("localizacao")
    val filtroDisponibilidade = LocalStorage.getFilter("disponibilidade")

    // Verifica se há algum filtro aplicado
    val filtroAplicado = filtroInteresse.isNullOrEmpty() && filtroLocalizacao.isNullOrEmpty() && filtroDisponibilidade.isNullOrEmpty()

    return if (filtroAplicado) {
        // Se nenhum filtro foi aplicado, retorna a lista completa sem filtrar
        usuarioDb
    } else {
        // Se algum filtro foi aplicado, aplica apenas os filtros nos campos relevantes
        usuarioDb.filter { usuario: UsuarioModel ->
            val interesseValido = filtroInteresse.isNullOrEmpty() || filtroInteresse.contains(usuario.interesse)
            val localizacaoValida = filtroLocalizacao.isNullOrEmpty() || filtroLocalizacao.contains(usuario.localizacao)
            val disponibilidadeValida = filtroDisponibilidade.isNullOrEmpty() || filtroDisponibilidade.contains(usuario.disponibilidade)

            interesseValido && localizacaoValida && disponibilidadeValida
        }
    }
}
