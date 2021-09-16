package br.com.fmarxds.clientfeatureserverff4jsample.controller

import org.ff4j.FF4j
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    value = ["/home"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
class HomeController(
    private val fF4j: FF4j,
) {

    @GetMapping
    fun home(): ResponseEntity<Map<String, Any>> {

        return ResponseEntity.ok(
            mapOf(
                Pair("features", fF4j.features),
                Pair("properties", fF4j.properties)
            )
        )

    }

}