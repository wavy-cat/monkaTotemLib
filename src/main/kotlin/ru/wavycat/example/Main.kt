package ru.wavycat.example

import ru.wavycat.monkaTotemLib.options.SkinType
import ru.wavycat.monkaTotemLib.options.TopLayers
import ru.wavycat.monkaTotemLib.TotemBuilder

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