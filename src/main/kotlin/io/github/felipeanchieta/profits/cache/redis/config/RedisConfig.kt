package io.github.felipeanchieta.profits.cache.redis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import redis.clients.jedis.Jedis

@Configuration
class RedisConfig {

    @Bean
    fun jedis() = Jedis("redis-11359.c1.us-east1-2.gce.cloud.redislabs.com", 11359).apply {
        connect()
        auth("pjOyttp0hlwE8BtTHoSdxaweLhv3Dcjf")
        flushAll()
    }

}