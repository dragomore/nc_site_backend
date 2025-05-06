package org.nativecapital.nc_site_backend.dto.notion_database.parent_object.page_parent

import com.fasterxml.jackson.annotation.JsonProperty

data class PageParent(
  val type: String,
  @JsonProperty("page_id") val pageId: String,
)
