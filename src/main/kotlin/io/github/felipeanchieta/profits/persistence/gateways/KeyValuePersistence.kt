package io.github.felipeanchieta.profits.persistence.gateways

interface KeyValuePersistence {

    fun set(key: String, value: String)

    fun get(key: String): String?

}