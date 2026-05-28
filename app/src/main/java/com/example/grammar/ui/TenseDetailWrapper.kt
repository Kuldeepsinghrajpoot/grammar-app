package com.example.grammar.ui

import androidx.compose.ui.platform.ComposeView
import com.example.grammar.ui.theme.GrammarTheme
import kotlin.Unit

object TenseDetailWrapper {
    @JvmStatic
    fun setContent(
        composeView: ComposeView,
        title: String,
        description: String,
        types: List<TenseTypeData>,
        onBackClick: () -> Unit
    ) {
        composeView.setContent {
            GrammarTheme {
                TenseDetailContent(
                    title = title,
                    description = description,
                    types = types,
                    onBackClick = onBackClick
                )
            }
        }
    }
}
