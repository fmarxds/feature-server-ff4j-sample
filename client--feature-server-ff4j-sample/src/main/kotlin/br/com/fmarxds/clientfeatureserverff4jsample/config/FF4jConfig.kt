package br.com.fmarxds.clientfeatureserverff4jsample.config

import br.com.fmarxds.clientfeatureserverff4jsample.config.property.FF4JProperty
import org.ff4j.FF4j
import org.ff4j.web.jersey2.store.FeatureStoreHttp
import org.ff4j.web.jersey2.store.PropertyStoreHttp
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnClass(FF4j::class)
class FF4jConfig(
    private val fF4JProperty: FF4JProperty,
) {

    @Bean
    fun getFF4j(): FF4j {

        val ff4j = FF4j()

        ff4j.propertiesStore = PropertyStoreHttp(fF4JProperty.url)
        ff4j.featureStore = FeatureStoreHttp(fF4JProperty.url)

        return ff4j

    }

}