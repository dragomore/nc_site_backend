package org.nativecapital.nc_site_backend.dto.notion_database.rich_text_object

import com.fasterxml.jackson.annotation.JsonProperty
import org.nativecapital.nc_site_backend.dto.notion_database.Annotations
import org.nativecapital.nc_site_backend.dto.notion_database.TypeNames

data class RichText(
  val type: TypeNames?,
  val text: Text?,
  val mention: Mention?,
  val equation: Equation?,
  val annotations: Annotations?,
  @JsonProperty("plain_text") val plainText: String?,
  val href: String?
)