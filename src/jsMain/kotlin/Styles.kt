import org.jetbrains.compose.web.css.*

object ThemeVariables {
    val backgroundColor by variable<CSSColorValue>()
    val mainColor by variable<CSSColorValue>()
    val accentColor by variable<CSSColorValue>()
}

object BaseStyles : StyleSheet() {
    init {
        root {
            ThemeVariables.mainColor(Color("#333"))
            ThemeVariables.accentColor(Color("#6200ea"))
            ThemeVariables.backgroundColor(Color("#f0f0f0"))
        }

        "#root" style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            minHeight(100.vh)
            color(ThemeVariables.mainColor.value())
            backgroundColor(ThemeVariables.backgroundColor.value())
        }

        "header" style {
            backgroundColor(ThemeVariables.accentColor.value())
            color(ThemeVariables.backgroundColor.value())
            flex(0, 0, 60.px)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            fontSize(1.5.cssRem)
        }

        "main" style {
            flex(1)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            padding(20.px)
            backgroundColor(ThemeVariables.backgroundColor.value())
        }

        "footer" style {
            backgroundColor(ThemeVariables.mainColor.value())
            color(ThemeVariables.backgroundColor.value())
            flex(0, 0, 40.px)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            fontSize(1.cssRem)
        }
    }

    val container by style {
        backgroundColor(ThemeVariables.backgroundColor.value())
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        flexGrow(1)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        maxWidth(800.px)
        width(100.percent)
//        borderRadius(8.px)
        padding(20.px)
    }
}
