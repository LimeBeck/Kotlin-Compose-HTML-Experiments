import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import app.softwork.routingcompose.BrowserRouter
import app.softwork.routingcompose.NavLink
import app.softwork.routingcompose.Router
import common.BaseStyles
import common.Theme
import common.ThemeProvider
import common.ThemeVariables
import components.Layout
import components.PageContent
import components.PageFooter
import components.PageHeader
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody {
        Style {
            root {
                when (ThemeProvider.theme) {
                    Theme.Light -> {
                        ThemeVariables.mainColor(Color("#201e1f"))
                        ThemeVariables.accentColor(Color("#1d7874"))
                        ThemeVariables.backgroundColor(Color("#F8F4E3"))
                    }

                    Theme.Dark -> {
                        ThemeVariables.mainColor(Color("#F8F4E3"))
                        ThemeVariables.accentColor(Color("#1d7874"))
                        ThemeVariables.backgroundColor(Color("#201e1f"))
                    }
                }
            }
        }

        Style(BaseStyles)

        Layout {
            PageHeader {
                H1 { Text("My delicious site") }
                Div {
                    components.Button("Switch theme") {
                        ThemeProvider.theme = ThemeProvider.theme.opposite
                    }
                }
            }
            PageContent {
                BrowserRouter("/") {
                    route("/") {
                        NavLink("/hello-world") {
                            Text("To Hello world!")
                        }
                    }
                    route("/hello-world") {
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
                }
            }
            PageFooter {
                Div { Text("Copyright by Limebeck (2024)") }
            }
        }
    }
}
