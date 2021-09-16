package br.com.fmarxds.clientfeatureserverff4jsample.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("ff4j")
data class FF4JProperty(

    val url: String,

)