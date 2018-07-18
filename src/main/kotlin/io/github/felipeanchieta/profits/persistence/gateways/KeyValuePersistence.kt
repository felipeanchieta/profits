package io.github.felipeanchieta.profits.persistence.gateways

interface KeyValuePersistence {

    fun set(key: String, value: String)

    fun getAll(): List<String>

}