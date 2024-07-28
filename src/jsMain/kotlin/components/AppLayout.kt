package components

import common.BaseStyles
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
        classes(BaseStyles.header)
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
        classes(BaseStyles.main)
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
        classes(BaseStyles.footer)
        attrs?.invoke(this)
    }) {
        content()
    }
}
