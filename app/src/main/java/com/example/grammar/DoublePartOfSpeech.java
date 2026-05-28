package com.example.grammar;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.DoublePartsWrapper;
import kotlin.Unit;

public class DoublePartOfSpeech extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_part_of_speach);

        ComposeView composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            DoublePartsWrapper.setContent(composeView, () -> {
                finish();
                return Unit.INSTANCE;
            });
        }
    }
}
