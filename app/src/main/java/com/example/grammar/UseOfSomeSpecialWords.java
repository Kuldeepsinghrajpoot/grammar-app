package com.example.grammar;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.SpecialWordsWrapper;
import kotlin.Unit;

public class UseOfSomeSpecialWords extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_of_some_special_words);

        ComposeView composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            SpecialWordsWrapper.setContent(composeView, () -> {
                finish();
                return Unit.INSTANCE;
            });
        }
    }
}
