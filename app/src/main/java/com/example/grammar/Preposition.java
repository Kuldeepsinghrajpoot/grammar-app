package com.example.grammar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.PrepositionWrapper;
import kotlin.Unit;

public class Preposition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preposition);

        ComposeView composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            PrepositionWrapper.setContent(composeView, () -> {
                finish();
                return Unit.INSTANCE;
            });
        }
    }
}
