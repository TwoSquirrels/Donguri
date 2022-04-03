/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT License, see /LICENSE file.
 */

package com.github.twosquirrels.donguri.discord

import com.github.twosquirrels.donguri.Config
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import org.slf4j.LoggerFactory

class Bot {
    val logger = LoggerFactory.getLogger(this.javaClass)
    val jda: JDA

    init {
        // build a Discord bot
        val jdaBuilder = JDABuilder.createDefault(Config.Env.DISCORD_TOKEN)
        jdaBuilder.setActivity(Activity.watching(Config.WATCHING))
        jda = jdaBuilder.build()
        jda.awaitReady()
        logger.info("Ready to Bot!")
    }
}
