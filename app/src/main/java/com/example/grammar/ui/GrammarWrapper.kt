package com.example.grammar.ui

import androidx.compose.ui.platform.ComposeView
import com.example.grammar.ui.theme.GrammarTheme
import kotlin.Unit

object GrammarWrapper {
    @JvmStatic
    fun setContent(
        composeView: ComposeView,
        title: String,
        htmlContent: String,
        onBackClick: () -> Unit
    ) {
        composeView.setContent {
            GrammarTheme {
                GenericGrammarContent(title, htmlContent, onBackClick)
            }
        }
    }
}
