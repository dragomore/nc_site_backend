package org.nativecapital.nc_site_backend.dto.notion_database.rich_text_object

import com.fasterxml.jackson.annotation.JsonProperty
import org.nativecapital.nc_site_backend.dto.notion_database.Link

data class Text(
  val content: String,
  val link: Link?,
)

enum class MentionTypes { database,
  date,
  link_preview,
  page,
  template_mention,
  user
}

data class Mention(
  val type: MentionTypes,
  val database: Database?,
  val date: Date?,
  @JsonProperty("link_preview") val linkPreview: Preview?,
  val page: Page?,
  @JsonProperty("template_mention") val templateMention: Template?,
  val user: User?,
)

data class Equation(
  val expression: String,
)