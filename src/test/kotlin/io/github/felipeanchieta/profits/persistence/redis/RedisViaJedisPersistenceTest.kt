package io.github.felipeanchieta.profits.persistence.redis

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.only
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import redis.clients.jedis.Jedis

class RedisViaJedisPersistenceTest {

    private val jedis: Jedis = mock()
    private val redisPersistence = RedisPersistence(jedis)

    @Test
    fun `should put a key-value`() {
        redisPersistence.set("key", "value")

        verify(jedis, only()).set("key", "value")
    }

    @Test
    fun `should get everything ever put into the cache`() {
        whenever(jedis.keys(eq("*"))).thenReturn((1..10).map { it.toString() }.toSet())

        val value = redisPersistence.getAll()

        verify(jedis, times(10)).get(any() as? String?)
        assertEquals((1..10).map { "something" }, value)
    }

    @Before
    fun setUp() {
        given(jedis.set(any() as? String?, any() as? String?)).willReturn("")
        given(jedis.get(any() as? String?)).willReturn("something")
    }

}