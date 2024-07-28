package common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class Theme {
    Dark,
    Light,
    ;

    val opposite
        get() =
            when (this) {
                Light -> Dark
                Dark -> Light
            }
}

object ThemeProvider {
    var theme by mutableStateOf(Theme.Light)
}
