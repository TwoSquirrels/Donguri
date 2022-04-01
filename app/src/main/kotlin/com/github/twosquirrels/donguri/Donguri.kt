/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT Lincense, see /LICENSE file.
 */

package com.github.twosquirrels.donguri

import com.github.twosquirrels.donguri.discord.Bot

class Donguri() {
    val bot = Bot()
}

fun main() {
    println("Launching Donguri...")
    val donguri = Donguri()

    // TODO: create a dedicated class
    do {
        print("Donguri CMD: ")
        val command = readLine()!!.toLowerCase()
        if (command == "") continue
        println(
            when (command) {
                "help" -> "commands: help, invite, ping, stop"
                "invite" -> "[TODO]"
                "ping" -> donguri.bot.jda.gatewayPing
                "stop" -> "Stopping this bot..."
                else -> "Unknown command: $command."
            }
        )
    } while (command != "stop")
    donguri.bot.jda.shutdownNow()
}
