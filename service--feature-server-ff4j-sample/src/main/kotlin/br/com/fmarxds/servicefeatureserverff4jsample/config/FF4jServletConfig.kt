package br.com.fmarxds.servicefeatureserverff4jsample.config

import org.ff4j.FF4j
import org.ff4j.conf.FF4jConfiguration
import org.ff4j.spring.boot.web.api.config.EnableFF4jSwagger
import org.ff4j.web.FF4jDispatcherServlet
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFF4jSwagger
@AutoConfigureAfter(FF4jConfiguration::class)
@ConditionalOnClass(FF4jDispatcherServlet::class)
class FF4jServletConfig : SpringBootServletInitializer() {

    @Bean
    fun ff4jDispatcherServletRegistrationBean(ff4jDispatcherServlet: FF4jDispatcherServlet?): ServletRegistrationBean<*> {
        return ServletRegistrationBean(ff4jDispatcherServlet, "/ff4j-web-console/*")
    }

    @Bean
    fun getFF4jDispatcherServlet(ff4j: FF4j?): FF4jDispatcherServlet {
        val ff4jConsoleServlet = FF4jDispatcherServlet()
        ff4jConsoleServlet.ff4j = ff4j
        return ff4jConsoleServlet
    }

}