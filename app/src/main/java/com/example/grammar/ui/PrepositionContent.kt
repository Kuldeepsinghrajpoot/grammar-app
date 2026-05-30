package com.example.grammar.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grammar.R
import com.example.grammar.ui.theme.GrammarTheme
import android.app.Activity
import androidx.core.view.WindowCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrepositionContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
    val view = LocalView.current
    val primaryColor = MaterialTheme.colorScheme.primary
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = primaryColor.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFF8F9FA)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("The Preposition", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = primaryColor,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Main Header
                Text(
                    text = "The Preposition",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "ऐसे शब्द जो दो noun या pronoun के बीच स्थान की दृष्टि से कुछ संबंध बतलाते है preposition कहे जाते है |",
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 24.dp),
                    color = Color.DarkGray
                )

                // 1. General use Section
                ContentSection(title = "General use of preposition", titleColor = Color(0xFF1976D2)) {
                    val genRules = listOf(
                        "1. प्रायः preposition अपने object के पूर्व आता है लेकिन निम्न दशाओं मे यह नियम लागू नहीं होता है -",
                        "(a) जब preposition का object 'that' (Relative pronoun) हो तो preposition अंत मे आता है ।\nExample:\nHere is the book that I asked for.",
                        "(b) Preposition वाक्य के अंत मे आता है जब Relative Pronoun छिपा हो ।\nExample:\nThis is the boy we were looking for.",
                        "(c) Preposition वाक्य के अंत मे आता है जब object कोई Interrogative pronoun हो ।\nExample:\nWhat are you talking about?",
                        "(d) Preposition उस दशा मे भी अंत मे आता है, जब verb का object Passive Present Participle हो ।\nExample:\nThey dislike being talked about.",
                        "(e) जोर देने (Emphasis) के लिए कभी-कभी object पहले और preposition अंत मे प्रयोग किया जाता है ।\nExample:\nNehru is remembered all the world over.",
                        "2. For, From, in, on का प्रयोग स्थान या समय दिखाने वाले शब्दो से पहले नहीं करते है ।\nExample:\nKindly wait a minute.",
                        "3. Preposition का प्रयोग Transitive verb तथा उसके object के बीच नहीं होता है ।\nExample:\nHe taught Mohan yesterday.",
                        "4. Considering, Concerning, Pending, Regarding, Touching, During, Bossing के बाद preposition का प्रयोग नहीं होता क्योंकि ये स्वयं preposition हैं |",
                        "Note: Persist, Refrain, Prohibit, Fond आदि के साथ Preposition आता है तो उसके पश्चात Gerund (V-ing) प्रयोग होता है ।\nExample:\nRam is fond of singing.",
                        "5. Order, obey, Violate, Resemble, Sign, Befit, Combat, Recommend, Pervade आदि Transitive verbs हैं, इनके पश्चात कोई preposition नहीं आता है ।"
                    )
                    genRules.forEachIndexed { index, s -> ColoredPoint(text = s, index = index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Special Comparisons
                ContentSection(title = "Special Rules & Comparisons", titleColor = Color(0xFF388E3C)) {
                    val comparisons = listOf(
                        "1. In and At:\nIn बड़े शहरों/देशों के लिए, At छोटे शहरों/गांवों के लिए ।\nExample:\nHe lives in India at Nowgong.",
                        "2. In and Into:\nIn स्थिरता (Stability) के लिए, Into गति (Motion) के लिए |\nExample:\nHe is in the house.\nHe jumped into the well.",
                        "3. On and Upon:\nOn स्थिरता के लिए, Upon गति के लिए |\nExample:\nThe book is on the table.\nThe cat jumped upon the table.",
                        "4. In and Within:\nIn समय के अंत में (at the end of), Within समय सीमा से पहले (before the end of) |\nExample:\nI will finish the work in a month.\nI will finish the work within a month.",
                        "5. After and In:\nAfter भूतकाल (Past) में समय दिखाता है, In भविष्यकाल (Future) में समय दिखाता है |\nExample:\nHe came after an hour.\nI will return in an hour.",
                        "6. With and By:\nWith यंत्र (Instrument) के लिए, By कर्ता (Agent/Doer) के लिए |\nExample:\nHe was killed by a robber with a gun.",
                        "7. Beside and Besides:\nBeside (बिल्कुल पास), Besides (के अतिरिक्त/अलावा) |\nExample:\nGo and sit beside him.\nBesides Hindi, he knows English.",
                        "8. Between and Among:\nBetween दो के लिए, Among दो से अधिक के लिए |\nExample:\nDistribute it between Ram and Shyam.\nDistribute it among all boys.",
                        "9. For, Since, From:\nFor समय की अवधि (Period of time), Since निश्चित समय (Point of time in Past), From Point of time (in all tenses) |\nExample:\nFor two hours.\nSince morning.\nFrom tomorrow.",
                        "10. Over and Above:\nOver ठीक ऊपर लंबवत (Vertical), Above ऊपर (लेकिन लंबवत होना आवश्यक नहीं) |\nExample:\nThe plane flew over my head.",
                        "11. Across and Along:\nAcross (एक ओर से दूसरी ओर), Along (साथ-साथ) |\nExample:\nThere is a bridge across the river.\nHe was walking along the road."
                    )
                    comparisons.forEachIndexed { index, s -> ColoredPoint(text = s, index = index + 1) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Fixed Prepositions
                ContentSection(title = "Fixed Prepositions (Common)", titleColor = Color(0xFF7B1FA2)) {
                    val fixed = listOf(
                        "• Afraid of (से डरा हुआ)", "• Agree with (से सहमत)",
                        "• Angry at (पर क्रोधित)", "• Arrive at (पर पहुँचना)",
                        "• Believe in (में विश्वास)", "• Belong to (का होना)",
                        "• Care for (की परवाह)", "• Complain of (की शिकायत)",
                        "• Depend on (पर निर्भर)", "• Die of (बीमारी से मरना)",
                        "• Different from (से अलग)", "• Full of (से भरा हुआ)",
                        "• Good at (में निपुण)", "• Listen to (को सुनना)",
                        "• Look for (की तलाश)", "• Married to (से विवाहित)",
                        "• Proud of (पर गर्व)", "• Wait for (का इंतजार)"
                    )
                    fixed.chunked(2).forEach { row ->
                        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)) {
                            row.forEach { item ->
                                Text(item, modifier = Modifier.weight(1f), fontSize = 14.sp, color = Color.Black)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrepositionPreview() {
    GrammarTheme {
        PrepositionContent()
    }
}
