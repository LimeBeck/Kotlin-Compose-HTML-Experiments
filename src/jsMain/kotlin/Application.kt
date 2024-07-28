import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import components.Layout
import components.PageContent
import components.PageFooter
import components.PageHeader
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposableInBody

enum class Theme { Dark, Light }

fun main() {
    renderComposableInBody {
        var theme by remember { mutableStateOf(Theme.Light) }
        Style {
            root {
                when (theme) {
                    Theme.Light -> {
                        ThemeVariables.mainColor(Color("#333"))
                        ThemeVariables.accentColor(Color("#6200ea"))
                        ThemeVariables.backgroundColor(Color("#f0f0f0"))
                    }
                    Theme.Dark -> {
                        ThemeVariables.mainColor(Color("#f0f0f0"))
                        ThemeVariables.accentColor(Color("#6200ea"))
                        ThemeVariables.backgroundColor(Color("#333"))
                    }
                }
            }
        }

        Style(BaseStyles)

        Layout {
            PageHeader {
                H1 { Text("My delicious site") }
                Div {
                    Button(attrs = {
                        onClick {
                            theme = when (theme) {
                                Theme.Light -> Theme.Dark
                                Theme.Dark -> Theme.Light
                            }
                        }
                    }) {
                        Text("Switch theme")
                    }
                }
            }
            PageContent {
                var counter: Int by remember { mutableStateOf(0) }
                Div {
                    Text("Hello World $counter")
                }
                Div {
                    Span {
                        Button(
                            attrs = {
                                onClick {
                                    counter++
                                }
                            },
                        ) {
                            Text("Increment")
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
