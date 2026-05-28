package com.example.grammar;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.TenseIntroWrapper;
import com.example.grammar.ui.TenseDetailWrapper;
import com.example.grammar.ui.TenseChartWrapper;
import com.example.grammar.ui.TenseTypeData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

public class Tense extends ComponentActivity {

    private ComposeView composeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tense_table);

        composeView = findViewById(R.id.compose_view);
        if (composeView != null) {
            showIntro();
        }
    }

    private void showIntro() {
        TenseIntroWrapper.setContent(composeView, 
            () -> {
                finish();
                return Unit.INSTANCE;
            }, 
            topic -> {
                if ("CHART".equals(topic)) {
                    showChart();
                } else {
                    showDetail(topic);
                }
                return Unit.INSTANCE;
            }
        );
    }

    private void showChart() {
        TenseChartWrapper.setContent(composeView, () -> {
            showIntro();
            return Unit.INSTANCE;
        });
    }

    private void showDetail(String topic) {
        String title;
        String description;
        List<TenseTypeData> types = new ArrayList<>();

        switch (topic) {
            case "PRESENT":
                title = "Present Tense";
                description = "The Present Tense indicates an action that is happening right now.";
                types.add(new TenseTypeData("1. Present Indefinite", "Subject + V1(s/es) + Object.", "He writes a letter."));
                types.add(new TenseTypeData("2. Present Continuous", "Subject + is/am/are + V(ing) + Object.", "He is writing a letter."));
                types.add(new TenseTypeData("3. Present Perfect", "Subject + has/have + V3 + Object.", "He has written a letter."));
                types.add(new TenseTypeData("4. Present Perfect Continuous", "Subject + has/have + been + V(ing) + since/for + Time.", "He has been writing a letter for two hours."));
                break;
            case "PAST":
                title = "Past Tense";
                description = "The Past Tense indicates an action that has already happened.";
                types.add(new TenseTypeData("1. Past Indefinite", "Subject + V2 + Object.", "He wrote a letter."));
                types.add(new TenseTypeData("2. Past Continuous", "Subject + was/were + V(ing) + Object.", "He was writing a letter."));
                types.add(new TenseTypeData("3. Past Perfect", "Subject + had + V3 + Object.", "He had written a letter."));
                types.add(new TenseTypeData("4. Past Perfect Continuous", "Subject + had + been + V(ing) + since/for + Time.", "He had been writing a letter since morning."));
                break;
            case "FUTURE":
                title = "Future Tense";
                description = "The Future Tense indicates an action that will happen.";
                types.add(new TenseTypeData("1. Future Indefinite", "Subject + will + V1 + Object.", "He will write a letter."));
                types.add(new TenseTypeData("2. Future Continuous", "Subject + will be + V(ing) + Object.", "He will be writing a letter."));
                types.add(new TenseTypeData("3. Future Perfect", "Subject + will have + V3 + Object.", "He will have written a letter."));
                types.add(new TenseTypeData("4. Future Perfect Continuous", "Subject + will have been + V(ing) + since/for + Time.", "He will have been writing a letter for two hours."));
                break;
            default:
                return;
        }

        TenseDetailWrapper.setContent(composeView, title, description, types, () -> {
            showIntro();
            return Unit.INSTANCE;
        });
    }
}
