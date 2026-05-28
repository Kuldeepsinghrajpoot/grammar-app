package com.example.grammar.ui

import androidx.compose.ui.platform.ComposeView
import com.example.grammar.ui.theme.GrammarTheme

object ArticlePronunciationWrapper {
    @JvmStatic
    fun setContent(composeView: ComposeView) {
        composeView.setContent {
            GrammarTheme {
                ArticlePronunciation()
            }
        }
    }
}
