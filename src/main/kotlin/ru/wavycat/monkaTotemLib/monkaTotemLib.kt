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

    /**
     * Generates a totem using the CLI.
     * Returns a pair of Boolean indicating whether the totem was generated successfully, and String containing the CLI output.
     */
    fun generate(): Pair<Boolean, String> {
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
        val ok = output == "\u001B[90m[\u001B[92m✔\u001B[90m] \u001B[94mGeneration completed successfully\u001B[0m"
        return ok to output
    }
}