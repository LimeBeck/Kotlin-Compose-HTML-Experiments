package pages

import androidx.compose.runtime.Composable
import app.softwork.routingcompose.NavLink
import org.jetbrains.compose.web.dom.Text

@Composable
fun HomePage() {
    NavLink("/hello-world") {
        Text("To Hello world!")
    }
    NavLink("/cat-fact") {
        Text("To Cat Facts!")
    }
}
