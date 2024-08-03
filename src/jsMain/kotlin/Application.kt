import androidx.compose.runtime.mutableStateOf
import app.softwork.routingcompose.HashRouter
import common.BaseStyles
import common.Theme
import common.Theme.Light.applyStyle
import common.ThemeProvider
import components.Layout
import components.PageContent
import components.PageFooter
import components.PageHeader
import domain.cat.CatServiceKtor
import domain.cat.CatServiceMock
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Style
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposableInBody
import pages.CatFactPage
import pages.HelloWorldPage
import pages.HomePage

fun main() {
    val client =
        HttpClient(Js) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            install(Logging)
        }

    renderComposableInBody {
        Style {
            root {
                ThemeProvider.theme.applyStyle()
            }
        }

        Style(BaseStyles)

        Layout {
            PageHeader {
                H1 { Text("LIMEBECK.DEV") }
                Div {
                    val themeState = mutableStateOf(false)
                    components.Switch("Theme", invertedColors = true, state = themeState) { checked ->
                        ThemeProvider.theme =
                            if (checked) {
                                Theme.Dark
                            } else {
                                Theme.Light
                            }
                    }
                    components.Button("Switch theme") {
                        ThemeProvider.theme = ThemeProvider.theme.opposite
                        themeState.value = !themeState.value
                    }
                }
            }
            PageContent {
                HashRouter("/") {
                    route("/") {
                        HomePage()
                    }
                    route("/hello-world") {
                        HelloWorldPage()
                    }
                    route("/cat-fact") {
                        val catServiceType = parameters?.map?.get("type")?.firstOrNull() ?: "impl"
                        val catService =
                            when (catServiceType) {
                                "mock" -> CatServiceMock()
                                else -> CatServiceKtor(client)
                            }
                        CatFactPage(catService)
                    }
                }
            }
            PageFooter {
                Div { Text("Copyright by Limebeck (2024)") }
            }
        }
    }
}
