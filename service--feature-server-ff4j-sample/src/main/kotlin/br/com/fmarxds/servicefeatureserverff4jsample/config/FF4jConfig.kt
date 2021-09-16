package br.com.fmarxds.servicefeatureserverff4jsample.config

import br.com.fmarxds.servicefeatureserverff4jsample.config.property.RedisProperty
import org.ff4j.FF4j
import org.ff4j.cache.FF4JCacheManager
import org.ff4j.cache.FF4jCacheManagerRedis
import org.ff4j.cache.InMemoryCacheManager
import org.ff4j.redis.RedisConnection
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc
import org.ff4j.springjdbc.store.FeatureStoreSpringJdbc
import org.ff4j.springjdbc.store.PropertyStoreSpringJdbc
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Configuration
@ConditionalOnClass(FF4j::class)
class FF4jConfig(
    private val redisProperty: RedisProperty,
) {

    @Bean
    fun getFF4j(
        dataSource: DataSource,
        ff4jCacheManager: FF4JCacheManager,
    ): FF4j {

        val ff4j = FF4j()

        ff4j.propertiesStore = PropertyStoreSpringJdbc(dataSource)
        ff4j.featureStore = FeatureStoreSpringJdbc(dataSource)
        ff4j.eventRepository = EventRepositorySpringJdbc(dataSource)

        ff4j.audit(true)
        ff4j.autoCreate(true)
        ff4j.cache(ff4jCacheManager)

        return ff4j

    }

    @Bean
    @Profile("local")
    fun ff4jCacheManagerLocal(): FF4JCacheManager {
        return InMemoryCacheManager()
    }

    @Bean
    @Profile("!local")
    fun ff4jCacheManager(): FF4JCacheManager {
        return FF4jCacheManagerRedis(RedisConnection(redisProperty.host!!, redisProperty.port!!))
    }

}