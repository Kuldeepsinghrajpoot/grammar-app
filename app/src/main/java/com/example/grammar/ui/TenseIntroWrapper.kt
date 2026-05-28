package com.example.grammar.ui

import androidx.compose.ui.platform.ComposeView
import com.example.grammar.ui.theme.GrammarTheme
import kotlin.Unit

object TenseIntroWrapper {
    @JvmStatic
    fun setContent(
        composeView: ComposeView, 
        onBackClick: () -> Unit,
        onNavigate: (String) -> Unit
    ) {
        composeView.setContent {
            GrammarTheme {
                TenseIntroContent(
                    onBackClick = onBackClick,
                    onNavigate = onNavigate
                )
            }
        }
    }
}
