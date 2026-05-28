package com.example.grammar;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.view.WindowCompat;
import com.example.grammar.ui.TenseChartWrapper;
import kotlin.Unit;

public class TenseTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Force light mode status bar
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary, getTheme()));
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(false);

        setContentView(R.layout.activity_tense_table);

        // activity_tense_table.xml has ComposeView with id compose_view
        ComposeView composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            TenseChartWrapper.setContent(composeView, () -> {
                finish();
                return Unit.INSTANCE;
            });
        }
    }
}