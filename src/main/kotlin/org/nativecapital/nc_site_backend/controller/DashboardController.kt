package org.nativecapital.nc_site_backend.controller

import org.nativecapital.nc_site_backend.client.NotionApiClient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/dashboard")
class DashboardController(private val notionApiClient: NotionApiClient) {
  
  @GetMapping("hello")
  fun hello(): ResponseEntity<Any> {
    return ResponseEntity.ok()
      .body("Hello World!")
  }
  
  @GetMapping("")
  fun getProjectName(@RequestParam database: String): Mono<ResponseEntity<Any>> {
    return notionApiClient.retrieveDatabase(database)
      .map { databaseDTO -> ResponseEntity.ok<Any>(databaseDTO) }
      .onErrorResume { e ->
        Mono.just(
          ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Ошибка: ${e.message}")
        )
      }
  }
}