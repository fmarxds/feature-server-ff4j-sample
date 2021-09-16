package br.com.fmarxds.servicefeatureserverff4jsample.config

import br.com.fmarxds.servicefeatureserverff4jsample.config.property.RedisProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    RedisProperty::class,
)
class PropertyConfig