package pages

import androidx.compose.runtime.*
import app.softwork.routingcompose.Router
import domain.cat.CatFact
import domain.cat.CatService
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun CatFactPage(catService: CatService) {
    val coroutineScope = rememberCoroutineScope()
    var catFact by remember { mutableStateOf<CatFact?>(null) }

    fun updateFact() {
        coroutineScope.launch {
            catFact = catService.getRandomCatFact()
        }
    }

    updateFact()

    Div {
        Text("Cat fact: ${catFact?.fact ?: "Not loaded yet"}")
    }
    Div {
        Span {
            components.Button("Get new fact") {
                updateFact()
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
