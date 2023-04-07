import io.github.terrakok.compose.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        BrowserViewportWindow("Compose Multiplatform Wizard") {
            App()
        }
    }
}
