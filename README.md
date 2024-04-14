# monkaTotemLib

> [!WARNING]
> Please don't take this project seriously if you're not @messengernew. Instead, use
> the [original Python library](https://github.com/wavy-cat/wavy-totem-lib).

You need to install Python 3.8 or higher, the wavy-totem-lib library (`pip3 install wavy-totem-lib`),
and [download the CLI](https://raw.githubusercontent.com/wavy-cat/wavy-totem-lib/main/cli.py).

### Code Example

```kotlin
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
        roundHead = true,
        scale = 10u
    )
    builder.generate()
}
```