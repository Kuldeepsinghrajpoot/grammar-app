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

                // Quick Navigation Menu
//                TenseQuickJumpMenu(onNavigate)

                Spacer(modifier = Modifier.height(24.dp))

                // 1. Concept
                ContentSection(title = "1. Basic Concept (Action Verb)", titleColor = Color(0xFF1976D2)) {
                    Text("Action verb को two points द्वारा show किया जाता है :", fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    ColoredPoint("Time - Action को किस time में करना है (Present, Past, Future) ।", 0)
                    ColoredPoint("State - Action किस state (Indefinite, Continuous, Perfect, Perfect Continuous) में है ।", 1)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    RuleBox("जब three time का multiply four state से करते है तो 12 Tense Generate होते हैं ।")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Hindi Identification
                ContentSection(title = "2. Hindi Identification (ID)", titleColor = Color(0xFF388E3C)) {
                    Text("Tense of hindi ID:", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C), modifier = Modifier.padding(bottom = 4.dp))
                    ColoredPoint("P.P.F = है, था, गा", 2)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("State of hindi ID:", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C), modifier = Modifier.padding(bottom = 4.dp))
                    val ids = listOf(
                        "Indefinite: ता, Future: गा",
                        "Continuous: रहा",
                        "Perfect: चुका",
                        "Perfect Continuous: रहा + समय"
                    )
                    ids.forEachIndexed { index, text -> ColoredPoint(text, index + 3) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Helping Verbs
                ContentSection(title = "3. Helping Verbs (5 Groups)", titleColor = Color(0xFF7B1FA2)) {
                    Text("12 tense में use होने वाली Helping verbs को 5 Groups में रख कर समझते है :", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    val groups = listOf(
                        "1. Will (Future)",
                        "2. Do form: do, does, did",
                        "3. Be form: is, am, are, was, were, be",
                        "4. Have Form: has, have, had",
                        "5. Been (Perfect Continuous)"
                    )
                    groups.forEachIndexed { index, text -> ColoredPoint(text, index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Main Verb Usage
                ContentSection(title = "4. Verb Usage in 12 Tenses", titleColor = Color(0xFFF57C00)) {
                    val verbUses = listOf(
                        "1. Present + Future Indefinite = I Form Affirmative",
                        "2. Past Indefinite Affirmative = Second form (V-2)",
                        "3. 6 Continuous tenses = ing form (V-ing)",
                        "4. 3 Perfect tenses = Third Form (V-3)",
                        "5. Present Indefinite (Singular Subject) = s, es form"
                    )
                    verbUses.forEachIndexed { index, text -> ColoredPoint(text, index + 5) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Negative + Wh
                ContentSection(title = "Negative + Wh Usage", titleColor = Color(0xFF1976D2)) {
                    val negRules = listOf(
                        "1. Present Indefinite: Negative/Wh के साथ do, does लगाते है। Singular के साथ does, plural के साथ do ।",
                        "2. Past Indefinite: Negative/Wh के साथ 'did' use करते है (with all subjects) ।"
                    )
                    negRules.forEachIndexed { index, text -> ColoredPoint(text, index + 2) }
                    Spacer(modifier = Modifier.height(8.dp))
                    RuleBox("Note: शेष all tenses के साथ helping verb होती है केवल Present/Past Indefinite Affirmative को छोड़ कर ।")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Structure
                ContentSection(title = "5. Structure of Tense", titleColor = Color(0xFF388E3C)) {
                    RuleBox("Subject + Helping Verb + Main Verb + Combination")
                    Text("किसी भी sentences का English translation करने के लिए 3 चीजों की जरुरत होती है: S + H.V + M.V", fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp), color = Color.Black)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 7. S form concept
                ContentSection(title = "S Form Concept (s, es, ies)", titleColor = Color(0xFF7B1FA2)) {
                    val sFormRules = listOf(
                        "1. 95% verbs के अंत में 's' का use होता है ।",
                        "2. जिन verbs के अंत में s, ss, sh, ch, z, o, x आया हो उन में 'es' लगाते है ।",
                        "3. अंत में y और पूर्व vowel हो तो 's' लगाते हैं (Example: plays).",
                        "4. अंत में y और पूर्व consonant हो तो y हटाकर 'ies' कर देते हैं (Example: tries)."
                    )
                    sFormRules.forEachIndexed { index, text -> ColoredPoint(text, index + 4) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 8. Verb Form Types
                ContentSection(title = "Verb Form (Regular vs Irregular)", titleColor = Color(0xFFF57C00)) {
                    Text("Action verb two type की होती हैं :-", fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    
                    Text("1. Regular verb (Weak verb):", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C))
                    ColoredPoint("जिसकी second, third form एक जैसी होती है जिसे D form (d, ed, ied) द्वारा बनाते है। लगभग 95% verbs Regular होती है।\nExample: Play-Played.", 0)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("2. Irregular verb (Strong verb):", fontWeight = FontWeight.Bold, color = Color(0xFFD32F2F))
                    ColoredPoint("इनकी second और third form को d form लगाकर नहीं बना सकते। इसे 3-3-13-23 logic द्वारा बना सकते है।", 1)
                    
                    Column(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
                        BulletPoint("first 3: तीनों form same", Color.Black)
                        BulletPoint("second 3: तीनों form different", Color.Black)
                        BulletPoint("13: first and third same", Color.Black)
                        BulletPoint("23: second and third same (but not D form)", Color.Black)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 9. Ing form rules
                ContentSection(title = "Rules for adding 'ing'", titleColor = Color(0xFFC62828)) {
                    val ingRules = listOf(
                        "1. अंत में letter e हो तो e हटा दिया जाता है (come-coming).",
                        "2. अंत में एक consonant और पूर्व एक vowel हो तो last letter double हो जाता है (stop-stopping).",
                        "3. अंत में y या double LL हो तो कुछ नहीं हटाते (cry-crying, call-calling).",
                        "4. अंत में ie हो तो ie को y मे बदल देते है (lie-lying).",
                        "5. अंत में ee, ye हो तो अंतिम e नहीं हटाते (see-seeing, dye-dyeing)."
                    )
                    ingRules.forEachIndexed { index, text -> ColoredPoint(text, index + 2) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 10. Verb Classifications
                ContentSection(title = "Verb Classifications", titleColor = Color(0xFF1976D2)) {
                    Text("प्रयोग के आधार पर verb के प्रकार :", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp), color = Color.Black)
                    val vClass = listOf(
                        "1. Transitive (सकर्मक): जो बिना object के अर्थ पूरा नहीं कर सकती (He writes a letter).",
                        "2. Intransitive (अकर्मक): जो बिना object के अर्थ पूरा कर सकती है (come, go, weep, laugh).",
                        "3. Finite: जो subject के person/number के अनुसार बदलती है (Rita is / They are).",
                        "4. Non-finites: जो subject से प्रभावित नहीं होती (Infinitive, Gerund, Participle).",
                        "5. Linking verb: जो complement को जोड़ती है (is, am, are, was, were).",
                        "6. Auxiliary verb: Helping verbs जो main verb की सहायता करती हैं ।"
                    )
                    vClass.forEachIndexed { index, text -> ColoredPoint(text, index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 11. Causative
                ContentSection(title = "Causative Verbs (प्रेरणा दायक)", titleColor = Color(0xFFC62828)) {
                    Text("(get, have, cause, make): जब कर्ता स्वयं कार्य न कर के किसी अन्य से कराता है ।", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    
                    Text("1. Active voice: make या cause ।", fontWeight = FontWeight.Bold, color = Color.Black)
                    RuleBox("Structure: Subject + make/cause + Doer + V-1")
                    ExampleItem("Example:", "He made me weep.\n(उसने मुझे रुलाया)")
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("2. Passive voice: get तथा have ।", fontWeight = FontWeight.Bold, color = Color.Black)
                    ExampleItem("Example:", "I got a letter written.\n(मैंने पत्र लिखवाया)")
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
