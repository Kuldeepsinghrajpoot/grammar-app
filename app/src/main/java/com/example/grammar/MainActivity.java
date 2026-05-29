package com.example.grammar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.compose.ui.platform.ComposeView;
import com.example.grammar.ui.GrammarWrapper;
import com.example.grammar.ui.TenseDetailWrapper;
import com.example.grammar.ui.TenseIntroWrapper;
import com.example.grammar.ui.TenseTypeData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Unit;

public class MainActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textContent;
    private ComposeView composeView;
    private View legacyContent;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(v -> finish());
        }

        TextView tvCopyright = findViewById(R.id.tvCopyright);
        if (tvCopyright != null) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            tvCopyright.setText("Written by Kalka Prasad Rajpoot \n App created by Kuldeep Singh \n © Copyright 2020-" + currentYear);
        }

        if (findViewById(R.id.main) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        textTitle = findViewById(R.id.textTitle);
        textContent = findViewById(R.id.textContent);
        composeView = findViewById(R.id.compose_view);
        legacyContent = findViewById(R.id.legacy_content);

        if (textContent != null) {
            textContent.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        }

        String topicKey = getIntent().getStringExtra("TOPIC_KEY");
        if (topicKey != null) {
            displayGrammarContent(topicKey);
        } else {
            updateUI("Grammar Guide", "Please select a topic.");
        }
    }

    private void displayGrammarContent(String key) {
        switch (key) {
            case "PRESENT":
                showTenseDetail("PRESENT");
                break;

            case "PAST":
                showTenseDetail("PAST");
                break;

            case "FUTURE":
                showTenseDetail("FUTURE");
                break;

            case "TENSE_INTRO":
                if (composeView != null && legacyContent != null) {
                    legacyContent.setVisibility(View.GONE);
                    composeView.setVisibility(View.VISIBLE);
                    TenseIntroWrapper.setContent(composeView, 
                        () -> { finish(); return Unit.INSTANCE; },
                        topic -> { showTenseDetail(topic); return Unit.INSTANCE; }
                    );
                }
                break;

            case "DOUBLE_PARTS":
                updateUI("Double Parts of Speech",
                        "<b>Double parts of speech refer to words that can act as two different parts of speech.</b><br><br>" +
                                "<b>Examples:</b><br>" +
                                "1. <b>Participle:</b> Verb + Adjective. Ex: A <i>barking</i> dog.<br>" +
                                "2. <b>Gerund:</b> Verb + Noun. Ex: <i>Swimming</i> is good exercise.<br>" +
                                "3. <b>Infinitive:</b> Verb + Noun. Ex: To <i>err</i> is human."
                );
                break;
            case "VOICE":
                updateUI("Voice",
                        "<b>Active and Passive Voice</b><br><br>" +
                                "1. <b>Active Voice:</b> The subject performs the action.<br>" +
                                "   • Structure: Subject + Verb + Object<br>" +
                                "   • Ex: Ram writes a letter.<br><br>" +
                                "2. <b>Passive Voice:</b> The subject receives the action.<br>" +
                                "   • Structure: Object + Be + V3 + by + Subject<br>" +
                                "   • Ex: A letter is written by Ram."
                );
                break;
            case "PREPOSITION":
                updateUI("The Preposition",
                        "<b>A Preposition shows the relationship between a noun/pronoun and other words.</b><br><br>" +
                                "<b>Common Prepositions:</b><br>" +
                                "• <b>In:</b> Ex: In the room.<br>" +
                                "• <b>On:</b> Ex: On the table.<br>" +
                                "• <b>At:</b> Ex: At the station.<br>" +
                                "• <b>By:</b> Ex: By bus.<br>" +
                                "• <b>With:</b> Ex: With a pen."
                );
                break;
            case "SENTENCE":
                updateUI("Sentence",
                        "<b>A sentence is a group of words that makes complete sense.</b><br><br>" +
                                "<b>Types of Sentences:</b><br>" +
                                "1. <b>Assertive:</b> Simple statement. Ex: I am a student.<br>" +
                                "2. <b>Interrogative:</b> Asks a question. Ex: Where are you going?<br>" +
                                "3. <b>Imperative:</b> Command or request. Ex: Please sit down.<br>" +
                                "4. <b>Exclamatory:</b> Strong feeling. Ex: What a beautiful day!<br>" +
                                "5. <b>Optative:</b> Wish or prayer. Ex: May God bless you."
                );
                break;
            case "SPECIAL_WORDS":
                updateUI("Special Words",
                        "<b>Usage of some special words that cause confusion:</b><br><br>" +
                                "1. <b>Say vs Tell:</b><br>" +
                                "   • He <i>said</i> that... (No object required)<br>" +
                                "   • He <i>told me</i> that... (Object required)<br><br>" +
                                "2. <b>Listen vs Hear:</b><br>" +
                                "   • <i>Listen</i> is intentional. Ex: Listen to music.<br>" +
                                "   • <i>Hear</i> is unintentional. Ex: I heard a noise."
                );
                break;
            default:
                updateUI("Grammar", "Details for this topic will be added soon.");
                break;
        }
    }

    private void showTenseDetail(String topic) {
        String title;
        String description;
        List<TenseTypeData> types = new ArrayList<>();

        if ("PRESENT".equals(topic)) {
            title = "Present Tense";
            description = "The Present Tense indicates an action that is happening right now.";
            types.add(new TenseTypeData("1. Present Indefinite", "Subject + V1(s/es) + Object.", "The sun rises in the east."));
            types.add(new TenseTypeData("2. Present Continuous", "Subject + is/am/are + V(ing) + Object.", "They are playing football in the field."));
            types.add(new TenseTypeData("3. Present Perfect", "Subject + has/have + V3 + Object.", "She has already finished her homework."));
            types.add(new TenseTypeData("4. Present Perfect Continuous", "Subject + has/have + been + V(ing) + since/for + Time.", "I have been living in this city for five years."));
        } else if ("PAST".equals(topic)) {
            title = "Past Tense";
            description = "The Past Tense indicates an action that has already happened.";
            types.add(new TenseTypeData("1. Past Indefinite", "Subject + V2 + Object.", "We went to the market yesterday."));
            types.add(new TenseTypeData("2. Past Continuous", "Subject + was/were + V(ing) + Object.", "It was raining heavily all night long."));
            types.add(new TenseTypeData("3. Past Perfect", "Subject + had + V3 + Object.", "The train had left before we reached the station."));
            types.add(new TenseTypeData("4. Past Perfect Continuous", "Subject + had + been + V(ing) + since/for + Time.", "He had been studying for three hours before he slept."));
        } else if ("FUTURE".equals(topic)) {
            title = "Future Tense";
            description = "The Future Tense indicates an action that will happen.";
            types.add(new TenseTypeData("1. Future Indefinite", "Subject + will + V1 + Object.", "They will visit us next Sunday."));
            types.add(new TenseTypeData("2. Future Continuous", "Subject + will be + V(ing) + Object.", "I will be waiting for you at the airport."));
            types.add(new TenseTypeData("3. Future Perfect", "Subject + will have + V3 + Object.", "She will have completed the project by next month."));
            types.add(new TenseTypeData("4. Future Perfect Continuous", "Subject + will have been + V(ing) + since/for + Time.", "We will have been traveling for a week by tomorrow morning."));
        } else {
            return;
        }

        updateModernDetailUI(title, description, types);
    }

    private void updateModernDetailUI(String title, String description, List<TenseTypeData> types) {
        if (composeView != null && legacyContent != null) {
            legacyContent.setVisibility(View.GONE);
            composeView.setVisibility(View.VISIBLE);
            TenseDetailWrapper.setContent(composeView, title, description, types, () -> {
                displayGrammarContent("TENSE_INTRO");
                return Unit.INSTANCE;
            });
        }
    }

    private void updateUI(String title, String content) {
        if (composeView != null && legacyContent != null) {
            composeView.setVisibility(View.GONE);
            legacyContent.setVisibility(View.VISIBLE);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        if (textTitle != null) {
            textTitle.setText(title);
        }
        if (textContent != null) {
            textContent.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        }
    }
}
