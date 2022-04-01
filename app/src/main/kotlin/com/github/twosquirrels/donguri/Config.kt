/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT License, see /LICENSE file.
 */

package com.github.twosquirrels.donguri

import io.github.cdimascio.dotenv.dotenv

object Config {
    // environment values
    object Env {
        val ADMIN_USERS: List<Long>
        val DISCORD_TOKEN: String

        init {
            val env = dotenv()

            ADMIN_USERS =
                env["ADMIN_USERS"]?.split(",")?.map(String::toLong) ?:
                listOf()
            DISCORD_TOKEN = env["DISCORD_TOKEN"]!!
        }
    }

    // bot constants
    val WATCHING = "/donguri"
}
