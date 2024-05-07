package br.com.fiap.mentorandoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_match")
data class MatchModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var aprendiz_id: Int = 0,
    var mentor_id: Int = 0,
    var aprendiz_liked: Boolean = false,
    var mentor_liked: Boolean = false,


    )
