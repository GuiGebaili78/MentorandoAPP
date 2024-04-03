package br.com.fiap.mentorandoapp.Api

import android.util.Log
import br.com.fiap.mentorandoapp.model.Mentor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray



suspend fun fetchMentorsFromApi(): List<Mentor> {
    return withContext(Dispatchers.IO) {
        try {
            val client = OkHttpClient.Builder().build()
            val request = Request.Builder()
                .url("https://660c75dd3a0766e85dbe2694.mockapi.io/api/v1/mentor")
                .build()
            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()
            val jsonArray = JSONArray(responseBody)
            val mentorList = mutableListOf<Mentor>()
            for (i in 0 until jsonArray.length()) {
                val mentorObject = jsonArray.getJSONObject(i)
                val mentor = Mentor(
                    id = mentorObject.getInt("id"),
                    nome = mentorObject.getString("nome"),
                    formacao = mentorObject.getString("formacao"),
                    experiencia = mentorObject.getString("experiencia"),
                    certificacao = mentorObject.getString("certificacao"),
                    biografia = mentorObject.getString("biografia"),
                    disponibilidade = mentorObject.getString("disponibilidade"),
                    localizacao = mentorObject.getString("localizacao"),
                    contato = mentorObject.getString("contato")
                )
                mentorList.add(mentor)
            }

            Log.d("MentorApiteste", "Erro ao buscar mentoresteste: ${mentorList.toString()}")
            mentorList
        } catch (e: Exception) {
            Log.e("MentorApi", "Erro ao buscar mentores: ${e.message}")
            emptyList()
        }
    }
}
