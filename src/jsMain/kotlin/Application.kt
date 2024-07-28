import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import components.Layout
import components.PageContent
import components.PageFooter
import components.PageHeader
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody {
        Style {
        }

        Style(BaseStyles)

        Layout {
            PageHeader {
                H1 { Text("My delicious site") }
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
