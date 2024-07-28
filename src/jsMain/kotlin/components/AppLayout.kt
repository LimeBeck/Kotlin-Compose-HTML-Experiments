package components

import BaseStyles
import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLElement

object AppLayoutContext

@Composable
fun Layout(content: @Composable AppLayoutContext.() -> Unit) {
    with(AppLayoutContext) {
        content()
    }
}

context(AppLayoutContext)
@Composable
fun PageHeader(
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable ElementScope<HTMLElement>.() -> Unit,
) {
    Header({
        attrs?.invoke(this)
    }) {
        content()
    }
}

context(AppLayoutContext)
@Composable
fun AppLayoutContext.PageContent(
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable ElementScope<HTMLElement>.() -> Unit,
) {
    Main({
        attrs?.invoke(this)
    }) {
        Div({
            classes(BaseStyles.container)
        }) {
            content()
        }
    }
}

context(AppLayoutContext)
@Composable
fun AppLayoutContext.PageFooter(
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable ElementScope<HTMLElement>.() -> Unit,
) {
    Footer({
        attrs?.invoke(this)
    }) {
        content()
    }
}
