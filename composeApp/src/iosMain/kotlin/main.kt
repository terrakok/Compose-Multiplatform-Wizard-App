import androidx.compose.ui.window.ComposeUIViewController
import io.github.terrakok.compose.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
