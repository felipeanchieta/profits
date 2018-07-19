package io.github.felipeanchieta.profits.cache.redis

import io.github.felipeanchieta.profits.cache.gateways.KeyValueCache
import org.springframework.stereotype.Repository
import redis.clients.jedis.Jedis

@Repository
class RedisCache(private val jedis: Jedis) : KeyValueCache {

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