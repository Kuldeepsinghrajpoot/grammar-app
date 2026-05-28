package com.example.grammar;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.PartOfSpeechWrapper;
import kotlin.Unit;

public class PartOfSpeech extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_of_speach);

        ComposeView composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            PartOfSpeechWrapper.setContent(composeView, () -> {
                finish();
                return Unit.INSTANCE;
            });
        }
    }
}
