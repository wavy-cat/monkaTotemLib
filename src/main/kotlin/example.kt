import options.SkinType
import options.TopLayers

fun main() {
    val builder = TotemBuilder(
        "python3",
        "cli.py",
        "skin.png",
        "totem.png",
        SkinType.AUTO,
        TopLayers.ALL,
        true,
        10u
    )
    builder.generate()
}