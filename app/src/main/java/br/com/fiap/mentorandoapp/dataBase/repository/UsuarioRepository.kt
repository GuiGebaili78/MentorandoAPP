package br.com.fiap.mentorandoapp.dataBase.repository

import android.content.Context
import br.com.fiap.mentorandoapp.dataBase.dao.UsuarioDb
import br.com.fiap.mentorandoapp.model.UsuarioModel

class UsuarioRepository(context: Context) {

    private val db = UsuarioDb.getDatabase(context).usuarioDao()

    fun salvar(usuarioModel: UsuarioModel): Long {
        return db.salvar(usuarioModel)
    }

    fun listarUsuarioModel(): List<UsuarioModel> {
        return db.listarUsuarioModel()
    }

    fun buscarUsuarioModelPeloId(id: Int): UsuarioModel {
        return db.buscarUsuarioModelPeloId(id)
    }

    fun usuarioLogin(email: String, password: String): UsuarioModel {
        return db.usuarioLogin(email, password)
    }
}

