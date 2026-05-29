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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grammar.R
import com.example.grammar.ui.theme.GrammarTheme
import android.app.Activity
import androidx.core.view.WindowCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TenseIntroContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onNavigate: (String) -> Unit = {}
) {
    val view = LocalView.current
    val primaryColor = MaterialTheme.colorScheme.primary
    val backgroundColor = Color(0xFFF8F9FA)

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = primaryColor.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Tense Introduction", fontWeight = FontWeight.Bold) },
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
                    text = "Tense",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                // 1. Concept
                ContentSection(title = "1. Basic Concept (Action Verb)", titleColor = Color(0xFF1976D2)) {
                    Text("Action verb को two points द्वारा show किया जाता है :", fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    
                    val conceptPoints = listOf(
                        "Time - Action को किस time में करना है |",
                        "State - Action किस state (Position) में है |",
                        "Time:- Time से समझते है की कोई भी action verb only three time मे होती है जो P.P F. (present ,past ,future)",
                        "State :- State का means है की कोई action verb only four state मे ही संभव है | (I.C - P.PC)\nWhere: I = Indefinite, C = Continuous, P = Perfect, PC = Perfect Continuous"
                    )
                    conceptPoints.forEachIndexed { index, s -> ColoredPoint(text = s, index = index) }

                    Spacer(modifier = Modifier.height(12.dp))
                    RuleBox("जब three time का multiply four state से करते है तो 12 Tense Generate होते हैं ।\nIC - PPC x PPF = 12 Tense")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Hindi Identification
                ContentSection(title = "2. Hindi Identification (ID)", titleColor = Color(0xFF388E3C)) {
                    Text("Tense of hindi ID:", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C), modifier = Modifier.padding(bottom = 4.dp))
                    ColoredPoint("P.P.F = है, था, गा", 2)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("State of hindi ID:", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C), modifier = Modifier.padding(bottom = 4.dp))
                    val ids = listOf(
                        "I = ता, Future = गा",
                        "C = रहा",
                        "P = चुका",
                        "PC = रहा समय"
                    )
                    ids.forEachIndexed { index, text -> ColoredPoint(text, index + 3) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Helping Verbs
                ContentSection(title = "3. Helping Verbs (5 Groups)", titleColor = Color(0xFF7B1FA2)) {
                    Text("12 tense में use होने वाली Helping verbs को 5 Groups में रख कर समझते है :", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    val groups = listOf(
                        "1. will (Future)",
                        "2. Do form - do, does, did",
                        "3. Be form - is, am, are, was, were, be",
                        "4. Have Form - has, have, had",
                        "5. Been (Perfect Continuous)"
                    )
                    groups.forEachIndexed { index, text -> ColoredPoint(text = text, index = index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Main Verb Usage
                ContentSection(title = "4. Main Verb Usage (Short Form)", titleColor = Color(0xFFF57C00)) {
                    val mvUsage = listOf(
                        "P P F - I = 121 (Indefinite Pattern)",
                        "6 Continuous = ing form (V-ing)",
                        "3 Perfect Tenses = III form (V-3)"
                    )
                    mvUsage.forEachIndexed { index, text -> ColoredPoint(text, index + 5) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Verb Usage details
                ContentSection(title = "5. Verbs Usage in 12 Tenses", titleColor = Color(0xFFC62828)) {
                    val verbUses = listOf(
                        "1. Present + Future Indefinite = I Form Affirmative",
                        "2. Past Indefinite Affirmative = Second form (V-2)",
                        "3. 6 Continuous ing",
                        "4. 3 Perfect III Form",
                        "5. Present Indefinite Affirmative = s, es (singular subject), no use s, es in plural subject."
                    )
                    verbUses.forEachIndexed { index, text -> ColoredPoint(text, index + 2) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Negative + Wh
                ContentSection(title = "Negative + Wh Usage (Helping Verbs)", titleColor = Color(0xFF1976D2)) {
                    val negRules = listOf(
                        "1. Present Indefinite के Negative और Wh के साथ do, does लगाते है ।",
                        "2. Past Indefinite = Negative + Wh के साथ helping verb 'did' use करते है ।"
                    )
                    negRules.forEachIndexed { index, text -> ColoredPoint(text, index + 4) }
                    Spacer(modifier = Modifier.height(8.dp))
                    RuleBox("Note: शेष all tenses के साथ helping verb होती है केवल Present/Past Indefinite Affirmative को छोड़ कर ।")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 7. Structure
                ContentSection(title = "6. Structure of Tense", titleColor = Color(0xFF388E3C)) {
                    Text("किसी भी sentences का English translation करने के लिए 3 चीजों की जरुरत होती है:", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    RuleBox("S + H.V + M.V")
                    Text("Note: Subject + helping verb + main verb + Combination", fontSize = 13.sp, color = Color.DarkGray, modifier = Modifier.padding(top = 4.dp))
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 8. S form concept
                ContentSection(title = "S Form Concept (s, es, ies)", titleColor = Color(0xFF7B1FA2)) {
                    val sFormRules = listOf(
                        "1. S form three types की है - s, es, ies",
                        "2. 95% verbs के अंत में 's' का use होता है ।",
                        "3. जिन verbs के अंत में s, ss, sh, ch, z, o, x आया हो उन में 'es' लगाते है ।",
                        "4. जिन verbs के अंत में y हो और y के पूर्व vowel हो तो अंत में 's' लगाते हैं ।\nExample:\nplay = plays.",
                        "5. जिन verbs के अंत में y हो और y के पूर्व कोई consonant हो तो y को remove कर 'ies' कर देते हैं ।\nExample:\nTry - tries."
                    )
                    sFormRules.forEachIndexed { index, text -> ColoredPoint(text, index + 3) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 9. Verb Form Types
                ContentSection(title = "Verb Form (Basic Points)", titleColor = Color(0xFFF57C00)) {
                    Text("Verb की 5 form होती हैं :", fontWeight = FontWeight.Medium, color = Color.Black)
                    val forms = listOf("1. First form", "2. Second form", "3. Third form", "4. Ing form", "5. S form")
                    forms.forEach { BulletPoint(it, Color.Black) }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Action verb two type की होती हैं :-", fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    
                    Text("1. Regular verb:", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C))
                    ColoredPoint("Regular verb का अर्थ एक जैसा | जिसकी second, third form एक जैसी होती है| जिसे D form द्वारा बनाते है | लगभग 95% verbs Regular verbs होती है |", 0)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Note:", fontWeight = FontWeight.Bold, color = Color.Black)
                    val notePoints = listOf(
                        "जिस verb के अंत मे y और उस के तुरंत पहले कोई vowel आया हो तो y के बाद ed लगाते है |\nExample:\nPlay - Played.",
                        "जिस verb के अंत मे y और उस के तुरंत पहले कोई consonant आया हो तो y को remove कर ied कर देते है |\nExample:\nReply - Replied."
                    )
                    notePoints.forEachIndexed { index, s -> ColoredPoint(text = s, index = index + 1) }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text("2. Irregular verb:", fontWeight = FontWeight.Bold, color = Color(0xFFD32F2F))
                    ColoredPoint("Irregular verb की second और third form को d form लगा कर नहीं बना सकते है | उसे 3 - 3 - 13 -23 द्वार ही बना सकते है |", 2)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    val irrNote = "Note: यदि verbs के अंत मे D आया हो तो कुछ verb के II form और III form मे d के स्थान पर t कर देते है |\nExample:\nSend - sent - sent."
                    ColoredPoint(text = irrNote, index = 3)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 10. Ing form rules
                ContentSection(title = "Rules for adding 'ing' to verb", titleColor = Color(0xFFC62828)) {
                    val ingRules = listOf(
                        "1. जिन verbs के अंत में letter e होता है तो ing use करते समय e हटा दिया जाता है ।\nExample:\ncome - coming.",
                        "2. जिन verbs के अंत में कोई एक consonant हो और उसके पूर्व एक vowel हो तो ing use करते समय last letter double हो जाता है ।\nExample:\nstop - stopping.",
                        "3. जिन verbs के अंत में y या double LL हो तो उन में ing लगाते समय y या double L को नहीं हटाते है ।\nExample:\nCry - crying\ncall - calling.",
                        "4. जिन शब्दों के अंत में consonant हो और उस के पहले double vowel हो तो last consonant double नहीं होता है ।\nExample:\nRead - Reading.",
                        "5. जिन शब्दों के अंत में N आया हो और उस से पहले कोई भी vowel आया हो तो अंतिम letter N double नहीं होता है ।\nExample:\nOpen - Opening",
                        "Note: यह Rule अप-वादों से भरा है अतः begin, run, आदि verb पर लागू नहीं होता है ।",
                        "6. जिन verb के अंत में ie हो उन में ing लगाते समय ie को y मे बदल देते है ।\nExample:\nLie - Lying\nDie - Dying.",
                        "7. जिन verbs के अंत में ee, ie, ye हो उन verbs के अंत में ing लगाते समय अंतिम e नहीं हटाते है ।\nExample:\nSee - Seeing\nDye - Dyeing"
                    )
                    ingRules.forEachIndexed { index, text -> ColoredPoint(text, index + 2) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 11. Verb Classifications
                ContentSection(title = "Verb Classifications", titleColor = Color(0xFF1976D2)) {
                    Text("पढ़ने और समझने की दृष्टि से दो part मे devide किया जा सकता है:", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    
                    val sentenceClassifications = listOf(
                        "(I.) Sentences में प्रयोग के आधार पर :",
                        "1. Transitive verb: ऐसी verb जो अपना अर्थ बिना object के पूरा नहीं कर सकती है |\nExample:\nHe writes a letter.",
                        "2. Intransitive verb: ऐसी verb जो अपना अर्थ बिना कर्म के पूरा कर सकती है |\nExample:\ncome, go, walk, run, fail, weep, pass, laugh, sit, stand, dance, jump, Rain, happen, seep, wander",
                        "3. Finite verb: ऐसी verbs जो अपने कर्ता एवं कर्म के अनुसार परिवर्तित होती है उनसे finite verb कहते है |\nExample:\nRita and sita are sisters.",
                        "4. Non-finite verb: verb के वे form जो न तो वाक्य के subject के person तथा numbers से प्रभावित होते है और न उन के tense की जानकारी होती है | (Infinitive, Gerund, Participle)",
                        "5. Linking verb: ऐसी verb जो किसी noun तथा noun, noun तथा pronoun अथवा किसी compliment को जोड़ने का कार्य करती है | (is, am, are, was, were, will be)\nExample:\nMy brother is a player.",
                        "(II.) Form के आधार पर verb दो प्रकार की होती है :",
                        "a. Regular verb और weak verb (D Form).",
                        "b. Irregular verb और strong verb (3-3-13-23 logic)."
                    )
                    
                    sentenceClassifications.forEachIndexed { index, text ->
                        ColoredPoint(text = text, index = index)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("Auxiliary Verbs details:", Color.Black)
                    
                    val auxDetails = listOf(
                        "(I) Primary Auxiliary: जब be form, do form तथा have form का प्रयोग main verb के साथ tense, negative तथा interrogative sentence बनाने मे प्रयोग करते है ।",
                        "(a) be form (is, am, are, was, were)",
                        "(b) do form (do, did, does)",
                        "(c) have form (has, have, had)",
                        "(II) Modal Auxiliary: ये verb mode प्रकट करने मे full verb की सहायता करती है | (shall, should, will , would, can, could, may, might, must, ought, need, dare, has to, have to, had to)"
                    )
                    auxDetails.forEachIndexed { index, s -> ColoredPoint(text = s, index = index + 2) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 12. Causative
                ContentSection(title = "Causative Verbs (प्रेरणा दायक क्रियाएँ)", titleColor = Color(0xFFC62828)) {
                    Text("(get, have, cause, make): जब कर्ता किसी कार्य को स्वयं न कर के किसी अन्य व्यक्ति से कराता है या करने की प्रेरणा देता है |", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(bottom = 12.dp))
                    
                    val causativeRules = listOf(
                        "Rule 1: Active Voice\nयदि sentence Active voice की verb का हो तो Translation करते समय make या cause लगा कर बनाते है |",
                        "Structure: subject(कर्ता) + make या cause + काम करने वाला + verb का first form + other sentences",
                        "Example:\nHe made me weep.\n(उसने मुझे रुलाया)\n\nHe caused me to weep.\n(उसने मुझे रुलाया)",
                        "Rule 2: Passive Voice\nयदि verb passive voice मे है तो get तथा have का प्रयोग होता है | साथ ही main verb की third form आती है |",
                        "Example:\nHe wrote a letter.\n\nI got a letter written.\nOR\nI had a letter written."
                    )
                    causativeRules.forEachIndexed { index, text -> ColoredPoint(text = text, index = index) }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TenseIntroPreview() {
    GrammarTheme {
        TenseIntroContent()
    }
}
