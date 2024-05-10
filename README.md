# monkaTotemLib

> [!WARNING]
> Please don't take this project seriously if you're not @messengernew. Instead, use
> the [original Python library](https://github.com/wavy-cat/wavy-totem-lib).

You need to install Python 3.8 or higher, the wavy-totem-lib library (`pip3 install wavy-totem-lib==1.5.1`),
and [download the CLI](https://raw.githubusercontent.com/wavy-cat/wavy-totem-lib/main/cli.py).

### Code Example

#### Kotlin

```kotlin
import ru.wavycat.monkaTotemLib.options.SkinType
import ru.wavycat.monkaTotemLib.options.TopLayers
import ru.wavycat.monkaTotemLib.TotemBuilder

fun main() {
    val builder = TotemBuilder("python3", "cli.py")
    val result = builder.generate(
        "skin.png",
        "totem.png",
        SkinType.AUTO,
        TopLayers.ALL,
        roundHead = true,
        scale = 10u
    )
    println(result)
}
```

#### Java

```java
import ru.wavycat.monkaTotemLib.TotemBuilder;
import ru.wavycat.monkaTotemLib.options.SkinType;
import ru.wavycat.monkaTotemLib.options.TopLayers;

class Main {
    public static void main(String[] args) {
        TotemBuilder builder = new TotemBuilder("python3", "cli.py");
        Boolean result = builder.generate("skin.png", "totem.png", SkinType.AUTO, TopLayers.ALL, true, 10);
        System.out.println(result);
    }
}
```

### Development Tools and Versions

During the development, the IntelliJ build system was used along with Kotlin version 1.9.23 and Liberica JDK 21.0.3.

### Installing

IDK. Try copying the `ru.wavycat.monkaTotemLib` package to the `srс/main/kotlin` folder in your project.
