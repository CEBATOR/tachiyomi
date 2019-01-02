/*
 * Copyright (C) 2018 The Tachiyomi Open Source Project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tachiyomi.domain.catalog.model

import tachiyomi.source.Source

sealed class Catalog {
  abstract val name: String
}

sealed class CatalogLocal : Catalog() {
  abstract val source: Source
}

data class CatalogInternal(
  override val name: String,
  override val source: Source
) : CatalogLocal()

data class CatalogInstalled(
  override val name: String,
  override val source: Source,
  val pkgName: String,
  val versionName: String,
  val versionCode: Int,
  val hasUpdate: Boolean = false
) : CatalogLocal()

data class CatalogRemote(
  override val name: String,
  val sourceId: Long,
  val pkgName: String,
  val versionName: String,
  val versionCode: Int,
  val lang: String,
  val apkName: String, // TODO this should probably be apkUrl
  val iconUrl: String
) : Catalog()