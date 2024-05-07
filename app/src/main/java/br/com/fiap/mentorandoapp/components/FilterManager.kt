package br.com.fiap.mentorandoapp.components

//Localstorage

object LocalStorage {
    private val storage: MutableMap<String, List<String>> = mutableMapOf()

    fun setFilter(key: String, listString: List<String>) {
        storage[key] = listString
    }

    fun getFilter(key: String): List<String>? {
        return storage[key]
    }

    fun checkFilter(key: String, valueToCheck: String): Boolean {
        return storage[key]?.contains(valueToCheck) ?: false
    }
}