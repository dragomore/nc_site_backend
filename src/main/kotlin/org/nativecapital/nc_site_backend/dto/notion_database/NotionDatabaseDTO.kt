package org.nativecapital.nc_site_backend.dto.notion_database

import com.fasterxml.jackson.annotation.JsonProperty
import org.nativecapital.nc_site_backend.dto.notion_database.database_properties.DatabaseProperties
import org.nativecapital.nc_site_backend.dto.notion_database.icon_object.IconObject
import org.nativecapital.nc_site_backend.dto.notion_database.parent_object.page_parent.PageParent
import org.nativecapital.nc_site_backend.dto.notion_database.rich_text_object.RichText

data class NotionDatabaseDTO(
  @JsonProperty("object") val objectName: String?,
  val id: String?,
  @JsonProperty("created_time") val createdTime: String?,
  @JsonProperty("created_by") val createdBy: PartialUser?,
  @JsonProperty("last_edited_time") val lastEditedTime: String?,
  @JsonProperty("last_edited_by") val lastEditedBy: PartialUser?,
  val title: List<RichText>?,
  val description: List<RichText>?,
  val icon: IconObject?,
  val cover: IconObject?,
  val properties: Map<String, DatabaseProperties>?,
  val parent: PageParent?,
  val url: String?,
  val archived: Boolean?,
  @JsonProperty("in_trash") val inTrash: Boolean?,
  @JsonProperty("is_inline") val isInline: Boolean?,
  @JsonProperty("public_url") val publicUrl: String?,
)





