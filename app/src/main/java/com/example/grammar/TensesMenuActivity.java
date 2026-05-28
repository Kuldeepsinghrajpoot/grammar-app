package com.example.grammar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TensesMenuActivity extends AppCompatActivity {

    public static final String TOPIC_KEY = "TOPIC_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Force light mode status bar
        android.view.Window window = getWindow();
        window.addFlags(android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary, getTheme()));
        androidx.core.view.WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(false);

        setContentView(R.layout.activity_tenses_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable Back Button in Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Handle Back Button Click
        toolbar.setNavigationOnClickListener(v -> finish());

        if (findViewById(R.id.main) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        Button btnPresent = findViewById(R.id.btnPresent);
        Button btnPast = findViewById(R.id.btnPast);
        Button btnFuture = findViewById(R.id.btnFuture);
        Button btnTenseIntro = findViewById(R.id.btnTenseIntro);
        Button btnTenseTable = findViewById(R.id.btnTenseTable);

        btnPresent.setOnClickListener(v -> openContentPage("PRESENT"));
        btnPast.setOnClickListener(v -> openContentPage("PAST"));
        btnFuture.setOnClickListener(v -> openContentPage("FUTURE"));
        btnTenseIntro.setOnClickListener(v -> openContentPage("TENSE_INTRO"));
        btnTenseTable.setOnClickListener(v -> openContentPage("TENSE_TABLE"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

    private void openContentPage(String topic) {
        if ("TENSE_TABLE".equals(topic)) {
            Intent intent = new Intent(TensesMenuActivity.this, TenseTable.class);
            startActivity(intent);
            return;
        }
        Intent intent = new Intent(TensesMenuActivity.this, MainActivity.class);
        intent.putExtra(TOPIC_KEY, topic);
        startActivity(intent);
    }
}
