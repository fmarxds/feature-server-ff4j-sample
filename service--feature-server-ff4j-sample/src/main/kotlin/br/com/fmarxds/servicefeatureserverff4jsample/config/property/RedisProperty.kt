package br.com.fmarxds.servicefeatureserverff4jsample.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("ff4j.cache-manager.redis")
data class RedisProperty(
    val host: String?,
    val port: Int?,
)
