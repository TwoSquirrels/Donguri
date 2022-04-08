/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT Lincense, see /LICENSE file.
 */

package com.github.twosquirrels.donguri

import com.github.twosquirrels.donguri.discord.Bot
import com.github.twosquirrels.donguri.util.defer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import kotlin.system.exitProcess

class Donguri() {
    val logger = LoggerFactory.getLogger(this.javaClass)
    var bot: Bot? = null

    init {
        logger.info("Launching Donguri...")
        defer("LaunchBot") {
            bot = Bot()
        }
        defer("LaunchServer") {}
    }

    fun shutdown() {
        logger.info("Shutting down Donguri...")
        bot?.jda?.shutdownNow()
        exitProcess(0)
    }
}

fun waitEnter(logger: Logger) {
    val yellow = { str: String ->
        val ESC = 0x1b.toChar()
        "$ESC[33m$str$ESC[m"
    }
    println(yellow("[HINT]: Press ENTER to shutdown"))
    readLine()
    logger.info("ENTER was pressed")
}

fun main() {
    val donguri = Donguri()
    waitEnter(donguri.logger)
    donguri.shutdown()
}
