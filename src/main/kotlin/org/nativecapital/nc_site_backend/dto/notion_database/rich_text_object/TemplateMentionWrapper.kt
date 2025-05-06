package org.nativecapital.nc_site_backend.dto.notion_database.rich_text_object

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type"
)
@JsonSubTypes(
  JsonSubTypes.Type(value = TemplateMentionDate::class, name = "template_mention_date"),
  JsonSubTypes.Type(value = TemplateMentionUser::class, name = "template_mention_user"),
)
sealed class TemplateMentionWrapper

data class TemplateMentionDate(
  @JsonProperty("template_mention_date") val templateMentionDate: String,
): TemplateMentionWrapper()

data class TemplateMentionUser(
  @JsonProperty("template_mention_user") val templateMentionUser: String,
): TemplateMentionWrapper()