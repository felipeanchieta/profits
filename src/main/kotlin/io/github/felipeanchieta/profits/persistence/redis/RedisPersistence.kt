package io.github.felipeanchieta.profits.persistence.redis

import io.github.felipeanchieta.profits.persistence.gateways.KeyValuePersistence
import org.springframework.stereotype.Repository
import redis.clients.jedis.Jedis

@Repository
class RedisPersistence(private val jedis: Jedis) : KeyValuePersistence {

    override fun set(key: String, value: String) {
        jedis.set(key, value)
    }

    override fun getAll(): List<String> {
        return jedis.keys("*").mapNotNull { get(it) }
    }

    private fun get(key: String): String? {
        return jedis.get(key)
    }

}