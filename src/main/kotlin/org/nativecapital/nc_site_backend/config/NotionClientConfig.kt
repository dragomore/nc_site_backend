package org.nativecapital.nc_site_backend.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

// WebClient with API keys

@Configuration
class NotionClientConfig(
  @Value("\${notion.api.route}") private val apiRoute: String,
  @Value("\${notion.api.key}") private val apiKey: String,
  @Value("\${notion.api.version}") private val apiVersion: String
) {
  
  @Bean
  fun webClient(): WebClient {
    
    return WebClient.builder()
      .baseUrl(apiRoute)
      .defaultHeader("Authorization", "Bearer $apiKey")
      .defaultHeader("Notion-Version", apiVersion)
      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .build()
  }
}