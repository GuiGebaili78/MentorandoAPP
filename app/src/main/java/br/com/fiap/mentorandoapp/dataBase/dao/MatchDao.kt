package br.com.fiap.mentorandoapp.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.mentorandoapp.model.MatchModel

@Dao
interface MatchDao {
    @Insert
    fun salvar(matchModel: MatchModel): Long

    @Query("SELECT * FROM tbl_match WHERE id = :id")
    fun buscarMatchModelPeloId(id: Int): MatchModel

    @Query("SELECT * FROM tbl_match WHERE aprendiz_id = :meu_id AND mentor_id = :mentor_id")
    fun buscarMatchAprendiz(meu_id: Int, mentor_id: Int): MatchModel

    @Query("SELECT * FROM tbl_match WHERE mentor_id = :meu_id AND aprendiz_id = :aprendiz_id")
    fun buscarMatchMentor(meu_id: Int, aprendiz_id: Int): MatchModel

    @Query("SELECT * FROM tbl_match ORDER BY id ASC")
    fun listarMatchModel(): List<MatchModel>

    @Query("SELECT mentor_id FROM tbl_match WHERE aprendiz_id = :meu_id AND aprendiz_liked = 1 AND mentor_liked = 1")
    fun obterMatchsDoAprendiz(meu_id: Int): List<Int>

    @Query("SELECT aprendiz_id FROM tbl_match WHERE mentor_id = :meu_id AND aprendiz_liked = 1 AND mentor_liked = 1")
    fun obterMatchsDoMentor(meu_id: Int): List<Int>

    @Query("UPDATE tbl_match SET aprendiz_liked = 1, mentor_liked = 1 WHERE id = :match_id")
    fun realizarMatch(match_id: Int)
}







