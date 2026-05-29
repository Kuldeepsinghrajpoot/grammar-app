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
                types.add(new TenseTypeData("1. Present Indefinite", "Subject + V1(s/es) + Object.", "The sun rises in the east."));
                types.add(new TenseTypeData("2. Present Continuous", "Subject + is/am/are + V(ing) + Object.", "They are playing football in the field."));
                types.add(new TenseTypeData("3. Present Perfect", "Subject + has/have + V3 + Object.", "She has already finished her homework."));
                types.add(new TenseTypeData("4. Present Perfect Continuous", "Subject + has/have + been + V(ing) + since/for + Time.", "I have been living in this city for five years."));
                break;
            case "PAST":
                title = "Past Tense";
                description = "The Past Tense indicates an action that has already happened.";
                types.add(new TenseTypeData("1. Past Indefinite", "Subject + V2 + Object.", "We went to the market yesterday."));
                types.add(new TenseTypeData("2. Past Continuous", "Subject + was/were + V(ing) + Object.", "It was raining heavily all night long."));
                types.add(new TenseTypeData("3. Past Perfect", "Subject + had + V3 + Object.", "The train had left before we reached the station."));
                types.add(new TenseTypeData("4. Past Perfect Continuous", "Subject + had + been + V(ing) + since/for + Time.", "He had been studying for three hours before he slept."));
                break;
            case "FUTURE":
                title = "Future Tense";
                description = "The Future Tense indicates an action that will happen.";
                types.add(new TenseTypeData("1. Future Indefinite", "Subject + will + V1 + Object.", "They will visit us next Sunday."));
                types.add(new TenseTypeData("2. Future Continuous", "Subject + will be + V(ing) + Object.", "I will be waiting for you at the airport."));
                types.add(new TenseTypeData("3. Future Perfect", "Subject + will have + V3 + Object.", "She will have completed the project by next month."));
                types.add(new TenseTypeData("4. Future Perfect Continuous", "Subject + will have been + V(ing) + since/for + Time.", "We will have been traveling for a week by tomorrow morning."));
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
