package org.nativecapital.nc_site_backend.client

import org.nativecapital.nc_site_backend.dto.notion_database.NotionDatabaseDTO
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class NotionApiClient(private val webClient: WebClient) {
  
  private val logger = LoggerFactory.getLogger(this::class.java)
  
  private fun toUUID(value: String): String {
    
    return value.replaceFirst(
      Regex("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})"), "$1-$2-$3-$4-$5"
    )
  }
  
  fun retrieveDatabase(databaseId: String): Mono<NotionDatabaseDTO> {
    // Создаем filter для логирования заголовков
    val logRequestHeaders = ExchangeFilterFunction.ofRequestProcessor { request ->
      // Логируем заголовки запроса
      logger.info("Request Headers: ${request.headers()}")
      Mono.just(request)
    }
    
    // Создаем WebClient с добавленным фильтром
    val webClientWithLogging =
      webClient.mutate()
        .filter(logRequestHeaders)  // Добавляем фильтр для логирования
        .build()
    
    return webClientWithLogging.get()
      .uri("databases/${toUUID(databaseId)}")
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(NotionDatabaseDTO::class.java)
      .doOnError { error -> logger.error("Error during getting database", error) }
  }
}