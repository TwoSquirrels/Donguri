/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT Lincense, see /LICENSE file.
 */

package com.github.twosquirrels.donguri

import com.github.twosquirrels.donguri.discord.Bot
import org.slf4j.LoggerFactory

import kotlin.system.exitProcess
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.Dispatchers

class Donguri() {
    val logger = LoggerFactory.getLogger(this.javaClass)
    var bot: Bot? = null

    init {
        logger.info("Launching Donguri...")
    }

    fun shutdown() {
        logger.info("Shutting down Donguri...")
        bot?.jda?.shutdownNow()
        exitProcess(0)
    }
}

fun main() {
    runBlocking {
        // launch
        val donguri = Donguri()

        launch(Dispatchers.Default) {
            Thread.currentThread().name = "LaunchBotThread"
            donguri.bot = Bot()
        }

        launch(Dispatchers.Default) {
            Thread.currentThread().name = "LaunchServerThread"
            // TODO
        }

        // wait ENTER
        val ESC = 0x1b.toChar()
        println("$ESC[33m[HINT]: Press ENTER to shutdown$ESC[m")
        readLine()

        donguri.logger.info("ENTER was pressed")
        donguri.shutdown()
    }
}
