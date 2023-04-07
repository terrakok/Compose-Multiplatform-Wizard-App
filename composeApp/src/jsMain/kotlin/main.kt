import io.github.terrakok.compose.ui.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        BrowserViewportWindow("Compose Multiplatform Wizard") {
            App()
        }
    }
}
