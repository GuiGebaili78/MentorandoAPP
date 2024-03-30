package br.com.fiap.mentorandoapp.dataBase.repository

import android.content.Context
import br.com.fiap.mentorandoapp.dataBase.dao.AprendizDb
import br.com.fiap.mentorandoapp.model.AprendizModel

class AprendizRepository(context: Context) {

    private val db = AprendizDb.getDatabase(context).aprendizDao()

    fun salvar(aprendizModel: AprendizModel): Long {
        return db.salvar(aprendizModel)
    }

    fun listarAprendizModel(): List<AprendizModel> {
        return db.listarAprendizModel()
    }

    fun buscarAprendizModelPeloId(id: Int): AprendizModel {
        return db.buscarAprendizModelPeloId(id)
    }
}

