package org.nativecapital.nc_site_backend.dto.notion_database

enum class ColorTypes { blue,
  blue_background,
  brown,
  brown_background,
  default,
  grey,
  grey_background,
  green_background,
  orange,
  orange_background,
  pink,
  pink_background,
  purple,
  purple_background,
  red,
  red_background,
  yellow,
  yellow_background
}

data class Annotations(
  val bold: Boolean,
  val italic: Boolean,
  val strikethrough: Boolean,
  val underline: Boolean,
  val code: Boolean,
  val color: ColorTypes,
)
