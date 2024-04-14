import options.SkinType
import options.TopLayers
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
        val output = reader.readText()
        return output
    }
}