/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT License, see /LICENSE file.
 */

package com.github.twosquirrels.donguri.util

import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

fun defer(
    name: String? = null,
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return CoroutineScope(dispatcher).launch() {
        if (name != null) Thread.currentThread().name = "${name}Thread"
        block()
    }
}
