package com.example.grammar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import java.util.Calendar;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Ensure Light Mode feel even in system dark mode
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // Match the toolbar color (colorPrimary)
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary, getTheme()));
        // Since primary is dark purple, use light (white) status bar icons
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(false);

        setContentView(R.layout.activity_navigation);

        // Map buttons to their respective Activity classes
        link(R.id.btnLsr, SoundSLR.class);
        link(R.id.btnPartsOfSpeech, PartOfSpeech.class);
        link(R.id.btnArticle, Article.class);
        link(R.id.btnTense, TensesMenuActivity.class); // Reverted to older menu version
        link(R.id.btnDoubleParts, DoublePartOfSpeech.class);
        link(R.id.btnVoice, Voice.class);
        link(R.id.btnPreposition, Preposition.class);
        link(R.id.btnSentence, Sentence.class);
        link(R.id.btnSpecialWords, UseOfSomeSpecialWords.class);

        // Set Copyright Text
        TextView tvCopyright = findViewById(R.id.tvCopyright);
        if (tvCopyright != null) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            tvCopyright.setText("Written by Kalka Prasad Rajpoot \n App created by Lexical Software \n © Copyright 2020-" + currentYear);
        }
    }

    private void link(int id, Class<?> target) {
        Button button = findViewById(id);
        if (button != null) {
            button.setOnClickListener(v -> {
                Intent intent = new Intent(NavigationActivity.this, target);
                startActivity(intent);
            });
        }
    }
}
