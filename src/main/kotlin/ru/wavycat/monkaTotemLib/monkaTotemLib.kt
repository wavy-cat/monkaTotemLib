package ru.wavycat.monkaTotemLib

import ru.wavycat.monkaTotemLib.options.SkinType
import ru.wavycat.monkaTotemLib.options.TopLayers
import java.io.BufferedReader
import java.io.InputStreamReader

class TotemBuilder(
    private val pythonPath: String,
    private val cliPath: String,
    private val skinPath: String,
    private val totemPath: String,
    private val skinType: SkinType,
    private val topLayers: TopLayers,
    private val roundHead: Boolean,
    private val scale: UInt
) {
    init {
        if (scale.toInt() == 0) {
            throw IllegalArgumentException("Scale cannot be zero")
        }
    }

    fun generate(): String {
        // Костыли. Фикс должен быть в https://github.com/wavy-cat/wavy-totem-lib/blob/main/cli.py
        val processBuilder = when (roundHead) {
            true -> ProcessBuilder(
                pythonPath,
                cliPath,
                skinPath,
                totemPath,
                "--skin-type",
                skinType.value,
                "--top-layers",
                topLayers.value,
                "--round-head",
                "true",
                "--scale",
                scale.toString()
            )
            false -> ProcessBuilder(
                pythonPath,
                cliPath,
                skinPath,
                totemPath,
                "--skin-type",
                skinType.value,
                "--top-layers",
                topLayers.value,
                "--scale",
                scale.toString()
            )
        }
        val process = processBuilder.start()
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        val output = reader.readText()
        return output
    }
}