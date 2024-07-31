import app.softwork.routingcompose.BrowserRouter
import common.BaseStyles
import common.Theme
import common.ThemeProvider
import common.ThemeVariables
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
import org.jetbrains.compose.web.css.Color
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
