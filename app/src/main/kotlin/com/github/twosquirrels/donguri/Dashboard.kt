/*
 * © 2022 TwoSquirrels
 * This file is licensed under the MIT License, see /LICENSE file.
 */

package com.github.twosquirrels.donguri

import ch.qos.logback.core.FileAppender
import net.dv8tion.jda.api.JDA

class Dashboard(val jda: JDA) {
  class LogbackAppender<E>: FileAppender<E>() {
    override fun doAppend(event: E) {
      super.doAppend(event)
      println("${super.encoder.encode(event).toString(Charsets.UTF_8)}")
    }
  }
}
