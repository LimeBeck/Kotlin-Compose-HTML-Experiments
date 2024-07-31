package pages

import androidx.compose.runtime.*
import app.softwork.routingcompose.RouteBuilder
import app.softwork.routingcompose.Router
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

context(RouteBuilder)
@Composable
fun HelloWorldPage() {
    val params = parameters?.map
    var counter: Int by remember { mutableStateOf(0) }
    Div {
        params?.map {
            Div {
                Span { Text("Param: ${it.key}: ${it.value}") }
            }
        }
    }
    Div {
        Text("Hello World $counter")
    }
    Div {
        Span {
            components.Button("Increment") {
                counter++
            }
        }
    }
    Div {
        Span {
            val router = Router.current
            components.Button("Back") {
                router.navigate("/")
            }
        }
    }
}
