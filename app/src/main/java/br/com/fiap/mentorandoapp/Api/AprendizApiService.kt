package br.com.fiap.mentorandoapp.Api

import android.util.Log
import br.com.fiap.mentorandoapp.model.Aprendiz
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray



suspend fun fetchAprendizFromApi(): List<Aprendiz> {
    return withContext(Dispatchers.IO) {
        try {
            val client = OkHttpClient.Builder().build()
            val request = Request.Builder()
                .url("https://660c75dd3a0766e85dbe2694.mockapi.io/api/v1/aprendiz")
                .build()
            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()
            val jsonArray = JSONArray(responseBody)
            val aprendizList = mutableListOf<Aprendiz>()
            for (i in 0 until jsonArray.length()) {
                val aprendizObject = jsonArray.getJSONObject(i)
                val aprendiz = Aprendiz(
                    id = aprendizObject.getInt("id"),
                    nome = aprendizObject.getString("nome"),
                    formacao = aprendizObject.getString("formacao"),
                    experiencia = aprendizObject.getString("experiencia"),
                    interesse = aprendizObject.getString("interesse"),
                    objetivo = aprendizObject.getString("objetivo"),
                    disponibilidade = aprendizObject.getString("disponibilidade"),
                    localizacao = aprendizObject.getString("localizacao"),
                    contato = aprendizObject.getString("contato")
                )
                aprendizList.add(aprendiz)
            }
            Log.d("AprendizApi", "Aprendizes buscados: ${aprendizList.toString()}")
            aprendizList
        } catch (e: Exception) {
            Log.e("AprendizApi", "Erro ao buscar aprendizes: ${e.message}")
            emptyList()
        }
    }
}

suspend fun fetchFilteredAprendizFromApi(areaAtuacao: List<String>, localizacao: List<String>, disponibilidade: List<String>): List<Aprendiz> {
    val allAprendizes = fetchAprendizFromApi()
    return allAprendizes.filter { aprendiz ->
        (areaAtuacao.isEmpty() || aprendiz.formacao in areaAtuacao) &&
                (localizacao.isEmpty() || aprendiz.localizacao in localizacao) &&
                (disponibilidade.isEmpty() || aprendiz.disponibilidade in disponibilidade)
    }
}
