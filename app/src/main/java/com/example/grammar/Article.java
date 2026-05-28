package com.example.grammar;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.ArticleWrapper;
import kotlin.Unit;

public class Article extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artical);

        ComposeView composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            ArticleWrapper.setContent(composeView, () -> {
                finish();
                return Unit.INSTANCE;
            });
        }
    }
}
