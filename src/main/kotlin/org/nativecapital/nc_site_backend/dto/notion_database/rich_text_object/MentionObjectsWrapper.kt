package org.nativecapital.nc_site_backend.dto.notion_database.rich_text_object

import com.fasterxml.jackson.annotation.JsonProperty

data class Database(
  val id: String,
)

data class Date(
  val start: String,
  val end: String?,
  @JsonProperty("time_zone") val timeZone: String?,
)

data class Preview(
  val url: String,
)

data class Page(
  val id: String,
)

data class Template(
  val type: String,
  val mention: TemplateMentionWrapper,
)

data class User(
  @JsonProperty("object") val obj: String,
  val id: String,
)