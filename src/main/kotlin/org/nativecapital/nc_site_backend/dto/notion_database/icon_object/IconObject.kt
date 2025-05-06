package org.nativecapital.nc_site_backend.dto.notion_database.icon_object

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.nativecapital.nc_site_backend.dto.notion_database.file_type.External
import org.nativecapital.nc_site_backend.dto.notion_database.file_type.File

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes(
  JsonSubTypes.Type(value = FileType::class, name = "file"),
  JsonSubTypes.Type(value = EmojiType::class, name = "emoji"),
  JsonSubTypes.Type(value = ExternalType::class, name = "external")
)
sealed class IconObject

data class FileType(
  val external: External?, val file: File?
): IconObject()

data class EmojiType(
  val emoji: String
): IconObject()

// Новый класс для типа external
data class ExternalType(
  val external: External
): IconObject()

