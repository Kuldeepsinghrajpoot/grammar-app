package com.example.grammar.ui

import androidx.compose.ui.platform.ComposeView
import com.example.grammar.ui.theme.GrammarTheme
import kotlin.Unit

object VoiceWrapper {
    @JvmStatic
    fun setContent(composeView: ComposeView, onBackClick: () -> Unit) {
        composeView.setContent {
            GrammarTheme {
                VoiceContent(onBackClick = onBackClick)
            }
        }
    }
}
