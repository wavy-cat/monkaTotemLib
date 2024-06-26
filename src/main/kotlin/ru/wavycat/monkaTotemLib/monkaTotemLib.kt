/*
 *                 Copyright WavyCat 2024.
 * Distributed under the Boost Software License, Version 1.0.
 *        (See accompanying file LICENSE or copy at
 *          https://www.boost.org/LICENSE_1_0.txt)
 */

package ru.wavycat.monkaTotemLib

import ru.wavycat.monkaTotemLib.options.SkinType
import ru.wavycat.monkaTotemLib.options.TopLayers
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class TotemBuilder(
    private val pythonPath: String,
    private val cliPath: String
) {
    init {
        if (!File(cliPath).exists()) {
            throw IllegalArgumentException("CLI script does not exist")
        }
    }

    /**
     * Generates a totem using the CLI.
     * Returns a pair of Boolean indicating whether the totem was generated successfully, and String containing the CLI output.
     */
    @JvmName("generate")
    fun generate(
        skinPath: String,
        totemPath: String,
        skinType: SkinType,
        topLayers: TopLayers,
        roundHead: Boolean,
        scale: UInt
    ): Boolean {
        when {
            scale == 0u -> throw IllegalArgumentException("Scale cannot be zero")
            !File(skinPath).exists() -> throw IllegalArgumentException("Skin file does not exist")
        }

        val processBuilder = ProcessBuilder(
            pythonPath,
            cliPath,
            skinPath,
            totemPath,
            "--skin-type",
            skinType.value,
            "--top-layers",
            topLayers.value,
            "--round-head",
            roundHead.toString(),
            "--scale",
            scale.toString()
        )
        val process = processBuilder.start()
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        val output = reader.readText().removeSuffix("\n")

        reader.close()

        return output == "\u001B[90m[\u001B[92m✔\u001B[90m] \u001B[94mGeneration completed successfully\u001B[0m"
    }
}