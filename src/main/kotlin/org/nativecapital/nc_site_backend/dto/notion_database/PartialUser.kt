package org.nativecapital.nc_site_backend.dto.notion_database

import com.fasterxml.jackson.annotation.JsonProperty

data class PartialUser(
  @JsonProperty("object") val userName: String,
  val id: String,
)
