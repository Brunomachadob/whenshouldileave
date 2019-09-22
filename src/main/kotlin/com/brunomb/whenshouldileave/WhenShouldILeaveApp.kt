package com.brunomb.whenshouldileave

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.*
import com.github.ajalt.clikt.parameters.types.float
import com.github.ajalt.clikt.parameters.types.long
import java.time.LocalTime


class WhenShouldILeaveApp : CliktCommand() {
    private val startTime: LocalTime by option()
        .convert { LocalTime.parse(it) }
        .prompt(text = "What's the start time", promptSuffix = "? ")

    private val lunchBreak: Long by option().long()
        .prompt(text = "Lunch break (minutes)", default = "45")

    private val workingHours: Float by option().float()
        .prompt(text = "Working hours", default = "7.6")

    private val extraHours: Float by option().float()
        .prompt(text = "Do you want to do some extra hours", promptSuffix = "? ", default = "0")

    override fun run() {
        startTime
            .plusMinutes((workingHours * 60).toLong())
            .plusMinutes((extraHours * 60).toLong())
            .plusMinutes(lunchBreak).also {
                print("You should leave at: $it")
            }
    }
}

fun main(args: Array<String>) = WhenShouldILeaveApp().main(args)