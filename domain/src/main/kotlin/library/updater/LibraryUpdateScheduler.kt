/*
 * Copyright (C) 2018 The Tachiyomi Open Source Project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tachiyomi.domain.library.updater

interface LibraryUpdateScheduler {

  fun schedule(categoryId: Long, target: LibraryUpdater.Target, timeInHours: Int)

  fun unschedule(categoryId: Long, target: LibraryUpdater.Target)

  fun unscheduleAll(categoryId: Long)

}