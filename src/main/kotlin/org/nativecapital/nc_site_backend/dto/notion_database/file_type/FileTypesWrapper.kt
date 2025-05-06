package org.nativecapital.nc_site_backend.dto.notion_database.file_type

import com.fasterxml.jackson.annotation.JsonProperty

data class External(
  val url: String,
)

data class File(
  val url: String,
  @JsonProperty("expiry_time") val expiryTime: String,
)