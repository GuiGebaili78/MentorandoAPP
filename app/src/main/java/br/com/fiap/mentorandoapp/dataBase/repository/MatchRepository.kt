package br.com.fiap.mentorandoapp.dataBase.repository


import android.content.Context
import br.com.fiap.mentorandoapp.dataBase.dao.MatchDb
import br.com.fiap.mentorandoapp.dataBase.dao.UsuarioDb
import br.com.fiap.mentorandoapp.model.MatchModel
import br.com.fiap.mentorandoapp.model.UsuarioModel

class MatchRepository(context: Context) {

    private val db = MatchDb.getDatabase(context).matchDao()

    fun salvar(matchModel: MatchModel): Long {
        return db.salvar(matchModel)
    }

    fun listarMatchModel(): List<MatchModel> {
        return db.listarMatchModel()
    }
    fun obterMatchsDoMentor(meu_id: Int): List<Int> {
        return db.obterMatchsDoMentor(meu_id)
    }

    fun obterMatchsDoAprendiz(meu_id: Int): List<Int> {
        return db.obterMatchsDoAprendiz(meu_id)
    }

    fun buscarMatchModelPeloId(id: Int): MatchModel {
        return db.buscarMatchModelPeloId(id)
    }

    fun buscarMatchAprendiz(meu_id: Int, mentor_id: Int): MatchModel {
        return db.buscarMatchAprendiz(meu_id, mentor_id)
    }

    fun buscarMatchMentor(meu_id: Int, aprendiz_id: Int): MatchModel {
        return db.buscarMatchMentor(meu_id, aprendiz_id)
    }
    fun realizarMatch(match_id: Int) {
        db.realizarMatch(match_id)
    }
}

