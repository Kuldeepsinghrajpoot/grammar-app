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
fun VoiceContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
                title = { Text("Active & Passive Voice", fontWeight = FontWeight.Bold) },
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
                    text = "Voice",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Rules Section
                ContentSection(title = "Active से Passive voice बनाने के नियम", titleColor = Color(0xFF388E3C)) {
                    Text(
                        text = "Rule :-",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1976D2),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    ColoredPoint("1. Active से passive voice बनाते समय Object को subject और subject को Object के स्थान पर ले आते है और object के पूर्व प्रायः by लगाते है ।", 0)
                    ColoredPoint("2. दिए हुए verb का Past Participle बना कर उस के पहले उसी tense का verb to be (is, am, are, was, were, be, been, being) का रूप लगा दिया जाता है ।", 1)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Passive Voice Table
                Text(
                    text = "The table of Passive voice",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                VoiceTable()

                Spacer(modifier = Modifier.height(24.dp))

                // Structure
                ContentSection(title = "Structure :-", titleColor = Color(0xFFF57C00)) {
                    RuleBox(text = "Object + helping verb (tense के अनुसार) + third form + other word + by + subject. (change into object)")
                    Spacer(modifier = Modifier.height(8.dp))
                    ExampleItem(label = "Example (Active):", example = "He kills a snake.")
                    ExampleItem(label = "Example (Passive):", example = "A snake is killed by him.")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Note Section
                ContentSection(title = "Note :-", titleColor = Color(0xFFC62828)) {
                    Column {
                        val notes = listOf(
                            "1. Present perfect continuous, past perfect continuous, future continuous, future perfect continuous का voice नहीं बनता है ।",
                            "2. केवल transitive verbs का ही passive voice बनता है in-transitive verb का नहीं क्योंकि इनमें object न होने से voice नहीं बनता है ।",
                            "3. कुछ verbs में by preposition के स्थान पर अन्य preposition का प्रयोग होता है । ये क्रिया निम्न है :-"
                        )
                        
                        notes.forEachIndexed { index, text ->
                            ColoredPoint(text = text, index = index + 2)
                        }
                        
                        // Preposition list
                        Column(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
                            PrepositionRule("(a) Surprised, Astonished, Disappointed... at लगाया जाता है।", "This news alarmed his father.", "His father was alarmed at this news.")
                            PrepositionRule("(b) Know के बाद Passive में to आता है।", "Everybody knows Gandhi ji.", "Gandhi ji known to everybody.")
                            PrepositionRule("(c) Pleased, Satisfied, Disgusted... with आता है।", "Your work satisfies the officers.", "The officers are satisfied with your work.")
                            PrepositionRule("(d) Contained तथा Interested के पश्चात in का प्रयोग होता है।", "This box contains many beautiful things.", "Many beautiful things are contained in this box.")
                        }
                        
                        Spacer(modifier = Modifier.height(12.dp))
                        ColoredPoint("4. Verbs के साथ जुड़ा preposition verbs का ही एक भाग होता है, उसे न लगाने पर verb का अर्थ ही बदल जाता है ।", 5)
                        ExampleItem("Example:", "Laugh (हसना)\n-\nlaugh at (मज़ाक उड़ाना)\n\nThe girls laughed at me.\nI was laughed at by the girls.")
                        
                        ColoredPoint("5. जिन verbs में दो object होते हैं। उनका passive voice बनाते समय उनमें से कोई एक subject हो जाता है तथा दूसरा अपने स्थान पर रहता है ।", 0)
                        ExampleItem("Example:", "He gave me a rupee.\n\nA rupee was given me by him.\nOR\nI was given a rupee by him.")
                        
                        ColoredPoint("6. Passive से Active बनाने के लिए नियमों का उलटा प्रयोग करते है ।", 1)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Interrogative
                ContentSection(title = "The voice of Interrogative", titleColor = Color(0xFF1976D2)) {
                    val rules = listOf(
                        "Rule 1 :- Interrogative Sentences का voice भी Interrogative मे बनता है जब sentences do, does, did से प्रारम्भ हो तो वे passive मे is, am, are, was, were आदि का प्रयोग कर बनते है।\n\nExample:\nDid he kill a lion?\nWas a lion killed by him?",
                        "2. यदि sentence प्रश्न वाचक शब्द से प्रारम्भ हो तो passive voice का sentence उसी प्रश्न वाचक शब्द से प्रारम्भ होगा।\n\nExample:\nWhen does he help me?\nWhen am I helped by him?",
                        "3. बहुत से प्रश्न वाचक sentences मे do, does, did का प्रयोग नहीं होता है क्योंकि उन मे अन्य Auxiliary verb आते है।\n\nExample:\nWill she write a book?\nWill a book be written by her?",
                        "4. जो वाक्य Who से प्रारम्भ होते हो उन का passive voice का वाक्य by whom से प्रारम्भ होता है। शेष नियम पूर्व जैसे होते है।\n\nExample:\nWho stole the pen?\nBy whom was the pen stolen?"
                    )
                    rules.forEachIndexed { index, text ->
                        ColoredPoint(text = text, index = index + 3)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Imperative
                ContentSection(title = "The change of Imperative sentences voice", titleColor = Color(0xFF388E3C)) {
                    Text("Rule :-", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C), modifier = Modifier.padding(bottom = 8.dp))
                    ColoredPoint("1. Imperative sentence के वाक्यों को Passive voice मे बदलने के लिए वाक्य को let से प्रारम्भ करते है। उस के बाद object लगाते है। इसके पश्चात be + III form of verb लगाते।", 0)
                    
                    SubSectionTitle("Structure :-", Color.Black)
                    RuleBox("let + object + be + III form of the verb")
                    ExampleItem("Example:", "Write a letter.\nLet a letter be written.")
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    ColoredPoint("2. जब Imperative Sentence negative हो तो do helping verb को हटा दिया जाता है।", 1)
                    ExampleItem("Example:", "Do not kill the bird.\nLet the bird not be killed.")
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    ColoredPoint("3. अगर प्रार्थना सूचक Sentence मे please या kindly आये तो passive voice बनाते समय please या kindly के स्थान पर you are requested to कर देते है ।", 2)
                    ExampleItem("Example:", "Please go to school.\nYou are requested to go to school.")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Special Voice
                ContentSection(title = "Change of some Special voice", titleColor = Color(0xFF7B1FA2)) {
                    Text("Rule", fontWeight = FontWeight.Bold, color = Color(0xFF7B1FA2), modifier = Modifier.padding(bottom = 8.dp))
                    
                    val specialRules = listOf(
                        "1. कुछ Active voice के वाक्यों मे verb का object एक शब्द न हो कर एक clause होता है तो passive voice मे verb के subject के लिए it का प्रयोग होता है ।\n\nExample:\nThey say that the king is coming.\nIt is said that the king is coming.",
                        "2. कुछ वाक्यों की बनावट Active voice मे be form + to + verb के क्रम मे होती है तो ऐसे वाक्यों का passive voice मे is, am, are, was, were के बाद to be आता है ।\n\nExample:\nHe is to help me.\nI am to be helped by him.",
                        "3. जिन sentences कि Active voice मे बनावट has have had + to verb के क्रम मे होती है तो उन का passive voice निम्न प्रकार बनता है ।\n\nExample:\nWe have to help him.\nHe has to be helped by us.",
                        "4. जिन Active voice मे बनावट can, could, may, might, should, would, verb के क्रम मे होती तो passive voice निम्न प्रकार होता है ।\n\nExample:\nHe should help her.\nShe should be helped by him."
                    )
                    specialRules.forEachIndexed { index, text ->
                        ColoredPoint(text = text, index = index + 4)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Pronoun Table
                Text(
                    text = "The table of pronoun",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC62828),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                PronounTableLayout()

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VoicePreview() {
    GrammarTheme {
        VoiceContent()
    }
}
