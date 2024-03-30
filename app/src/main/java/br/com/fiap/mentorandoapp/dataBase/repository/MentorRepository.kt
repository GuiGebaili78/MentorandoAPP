package br.com.fiap.mentorandoapp.dataBase.repository

import android.content.Context
import br.com.fiap.mentorandoapp.dataBase.dao.AprendizDb
import br.com.fiap.mentorandoapp.dataBase.dao.MentorDb
import br.com.fiap.mentorandoapp.model.AprendizModel
import br.com.fiap.mentorandoapp.model.MentorModel

class MentorRepository(context: Context) {

    private val db = MentorDb.getDatabase(context).mentorDao()

    fun salvar(mentorModel: MentorModel): Long {
        return db.salvar(mentorModel)
    }

    fun listarMentorModel(): List<MentorModel> {
        return db.listarMentorModel()
    }


    fun buscarMentorModelPeloId(id: Int): MentorModel {
        return db.buscarMentorModelPeloId(id)
    }

}
