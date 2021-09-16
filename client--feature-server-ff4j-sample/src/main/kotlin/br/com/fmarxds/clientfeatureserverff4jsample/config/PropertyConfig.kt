package br.com.fmarxds.clientfeatureserverff4jsample.config

import br.com.fmarxds.clientfeatureserverff4jsample.config.property.FF4JProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    FF4JProperty::class
)
class PropertyConfig