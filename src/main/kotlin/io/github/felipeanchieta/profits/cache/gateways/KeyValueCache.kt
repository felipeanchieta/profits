package io.github.felipeanchieta.profits.cache.gateways

interface KeyValueCache {

    fun set(key: String, value: String)

    fun getAll(): List<String>

}