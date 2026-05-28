package com.example.grammar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Force light mode status bar for splash
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.WHITE);
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(true);

        setContentView(R.layout.activity_splash);

        // Delay for 1.5 seconds then transition to NavigationActivity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, NavigationActivity.class);
            startActivity(intent);
            finish();
        }, 1500);
    }
}