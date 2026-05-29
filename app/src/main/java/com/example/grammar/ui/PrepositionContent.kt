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

                // General use Section
                ContentSection(title = "General use of preposition", titleColor = Color(0xFF1976D2)) {
                    SubSectionTitle("Rule :-", Color(0xFF1976D2))
                    
                    Text("1. प्रायः preposition अपने object के पूर्व आता है लेकिन निम्न दशाओं मे यह नियम लागू नहीं होता है -", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp), color = Color.Black)
                    
                    val points = listOf(
                        "(a) जब preposition का object 'that' (Relative pronoun) हो तो preposition अंत मे आता है ।\nExample:\nHere is the book that I asked for.",
                        "(b) Preposition वाक्य के अंत मे आता है जब Relative Pronoun छिपा हो ।\nExample:\nThis is the boy we were looking for.",
                        "(c) Preposition वाक्य के अंत मे आता है जब object कोई Interrogative pronoun हो ।\nExample:\nWhat are you talking about?",
                        "(d) Preposition उस दशा मे भी अंत मे आता है, जब verb का object Passive Present Participle हो ।\nExample:\nThey dislike being talked about.",
                        "(e) जोर देने (Emphasis) के लिए कभी-कभी object पहले और preposition अंत मे प्रयोग किया जाता है ।\nExample:\nNehru is remembered all the world over."
                    )
                    
                    points.forEachIndexed { index, point ->
                        ColoredPoint(text = point, index = index)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    ColoredPoint("2. For, From, in, on का प्रयोग स्थान या समय दिखाने वाले शब्दो से पहले नहीं करते है ।\nExample:\nKindly wait a minute.", 5)

                    Spacer(modifier = Modifier.height(8.dp))
                    ColoredPoint("3. Preposition का प्रयोग Transitive verb तथा उसके object के बीच नहीं होता है ।\nExample:\nHe taught Mohan yesterday.", 0)

                    Spacer(modifier = Modifier.height(8.dp))
                    val p4 = "4. Considering, Concerning, Pending, Regarding, Touching, During, Bossing के बाद preposition का प्रयोग नहीं होता क्योंकि ये स्वयं preposition हैं ।"
                    ColoredPoint(text = p4, index = 1)
                    
                    val p4Note = "Note: Persist, Refrain, Prohibit, Fond आदि के साथ Preposition आता है तो उसके पश्चात Gerund (V-ing) प्रयोग होता है ।\nExample:\nRam is fond of singing."
                    ColoredPoint(text = p4Note, index = 2)

                    Spacer(modifier = Modifier.height(8.dp))
                    ColoredPoint("5. Order, obey, Violate, Resemble, Sign, Befit, Combat, Recommend, Pervade आदि Transitive verbs हैं, इनके पश्चात कोई preposition नहीं आता है ।", 3)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Special Use Section
                ContentSection(title = "Special use of Preposition", titleColor = Color(0xFF388E3C)) {
                    SubSectionTitle("Rules and Comparisons :-", Color(0xFF388E3C))

                    val comparisons = listOf(
                        "1. in and at" to "(I) in का प्रयोग बड़े शहरों/स्थानों के साथ होता है, at छोटे शहरों/ग्रामों के लिए ।\n(II) in समय के भाग (Period of time) के लिए, at निश्चित समय (Point of time) के लिए ।\n\nExample:\nHe lives in Delhi.\n(वह दिल्ली में रहता है)\n\nHe lives at Nowgong.\n(वह नौगांव में रहता है)\n\nI will come in the morning.\n(मैं सुबह आऊंगा)\n\nI will come at 5 o'clock.\n(मैं 5 बजे आऊंगा)",
                        "2. in and into" to "in: स्थिरता (Stability) के लिए ।\ninto: गति (Motion) के लिए ।\n\nExample:\nHe is in the house.\n(वह घर में है)\n\nHe jumped into the well.\n(वह कुएं में कूद गया)",
                        "3. on and upon" to "on: स्थिरता/समीप संबंध के लिए ।\nupon: गति/बाहर से अंदर प्रवेश के लिए ।\n\nExample:\nThe book is on the table.\n(पुस्तक मेज पर है)\n\nThe dog jumped upon the table.\n(कुत्ता मेज पर कूद गया)",
                        "4. in and within" to "in: समय के अंत में (at the end of).\nwithin: समय सीमा से पहले (before the end of).\n\nExample:\nI will finish the work in a month.\n(मैं एक महीने में काम खत्म कर लूंगा - यानी महीने के अंत तक)\n\nI will finish the work within a month.\n(मैं एक महीने के भीतर काम खत्म कर लूंगा - यानी महीना खत्म होने से पहले)",
                        "5. after and in" to "after: भूतकाल (Past) में समय दिखाता है ।\nin: भविष्यकाल (Future) में समय दिखाता है ।\n\nExample:\nHe came after an hour.\n(वह एक घंटे के बाद आया)\n\nI will return in an hour.\n(मैं एक घंटे में वापस आऊंगा)",
                        "6. to" to "गतिशील अवस्था के लिए प्रयोग होता है । 'to' का अर्थ प्रायः 'कि ओर' होता है ।\nExample:\nI went to school.\n(मैं स्कूल गया)",
                        "7. with and by" to "with: यंत्र (Instrument) द्वारा कार्य को दिखाता है ।\nby: करने वाले (Agent/Doer) के लिए आता है ।\nExample:\nHe was killed by a robber with a gun.\n(वह एक डाकू द्वारा बंदूक से मारा गया)",
                        "8. beside and besides" to "beside: बिल्कुल नज़दीक (by the side of).\nbesides: के अतिरिक्त (in addition to).\nExample:\nYour cow was grazing beside my field.\n(तुम्हारी गाय मेरे खेत के पास चर रही थी)",
                        "9. between and among" to "between: दो व्यक्तियों/वस्तुओं के लिए ।\namong: दो से अधिक के लिए ।\nExample:\nI distribute these pens between Ram and Mohan.\n(मैं ये पेन राम और मोहन के बीच बांटता हूं)\n\nI distribute these sweets among all the students.\n(मैं ये मिठाइयां सभी छात्रों के बीच बांटता हूं)",
                        "10. from, for, since" to "for: समय की अवधि (period of time).\nsince: समय का बिंदु (point of time).\nfrom: point of time बताता है, use perfect continuous को छोड़ कर सभी tenses मे होता है ।\n\nExample:\nI have been playing for two hours.\n(मैं दो घंटे से खेल रहा हूँ)\n\nI have been playing since morning.\n(मैं सुबह से खेल रहा हूँ)\n\nI will start my work from tomorrow.\n(मैं कल से अपना काम शुरू करूँगा)",
                        "11. over and above" to "over: ठीक ऊपर लंबवत (Vertical).\nabove: ऊपर लेकिन लंबवत होना आवश्यक नहीं ।\nExample:\nThe plan flew over my head.\n(विमान मेरे सिर के ऊपर से उड़ गया)"
                    )
                    
                    comparisons.forEachIndexed { index, pair ->
                        PrepositionColoredItem(pair.first, pair.second, index)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                RuleBox("Note: इनके अतिरिक्त सैंकड़ों preposition हैं, लेकिन इनका प्रयोग दैनिक जीवन मे अधिक होता है ।")

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun PrepositionColoredItem(title: String, description: String, index: Int) {
    val bgColor = PointColors[index % PointColors.size]
    Surface(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        color = bgColor,
        shape = MaterialTheme.shapes.small
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, color = Color(0xFF1976D2), fontSize = 16.sp)
            Text(text = description, fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(top = 4.dp))
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
