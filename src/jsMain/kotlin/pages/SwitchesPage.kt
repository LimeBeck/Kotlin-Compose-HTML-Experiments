package pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import app.softwork.routingcompose.NavLink
import components.Switch
import org.jetbrains.compose.web.dom.Text

@Composable
fun SwitchesPage() {
    val state = mutableStateOf(false)
    Switch("123", state = state)
    Switch("Disabled", disabled = true, state = state)

    NavLink("/") {
        Text("Back to the main page")
    }
}
