package com.example.grammar;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.VoiceWrapper;
import kotlin.Unit;

public class Voice extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        ComposeView composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            VoiceWrapper.setContent(composeView, () -> {
                finish();
                return Unit.INSTANCE;
            });
        }
    }
}
