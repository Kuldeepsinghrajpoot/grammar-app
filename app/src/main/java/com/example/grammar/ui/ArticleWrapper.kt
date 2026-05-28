package com.example.grammar.ui

import androidx.compose.ui.platform.ComposeView
import com.example.grammar.ui.theme.GrammarTheme
import kotlin.Unit

object ArticleWrapper {
    @JvmStatic
    fun setContent(composeView: ComposeView, onBackClick: () -> Unit) {
        composeView.setContent {
            GrammarTheme {
                ArticleContent(onBackClick = onBackClick)
            }
        }
    }
}
