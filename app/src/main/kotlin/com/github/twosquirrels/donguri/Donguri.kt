/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT Lincense, see /LICENSE file.
 */

package com.github.twosquirrels.donguri

import com.github.twosquirrels.donguri.discord.Bot
import org.slf4j.LoggerFactory

class Donguri() {
    val bot = Bot()
}

fun main() {
    val logger = LoggerFactory.getLogger(Donguri::class.java)

    logger.info("Launching Donguri...")
    val donguri = Donguri()

    // TODO: Dashboard
    do {
        print("> ")
        val command = readLine()!!.lowercase()
    } while (command != "stop")

    logger.info("Shutting down Donguri...")
    donguri.bot.jda.shutdownNow()
}
