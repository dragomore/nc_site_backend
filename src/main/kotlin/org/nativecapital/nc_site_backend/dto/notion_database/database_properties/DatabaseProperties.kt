package org.nativecapital.nc_site_backend.dto.notion_database.database_properties

import org.nativecapital.nc_site_backend.dto.notion_database.PropertyTypes

data class DatabaseProperties(
  val id: String?, val name: String?, val description: String?, val type: PropertyTypes?
)
