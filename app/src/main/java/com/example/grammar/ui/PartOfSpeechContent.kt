package com.example.grammar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
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
fun PartOfSpeechContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
                title = { Text("Parts of Speech", fontWeight = FontWeight.Bold) },
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
                    text = "Parts of Speech",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )

                Text(
                    text = "शब्दों को उनके कार्यों के आधार पर 8 मुख्य भागों में विभाजित किया गया है :",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // 1. Definitions
                ContentSection(title = "Definitions & Examples", titleColor = Color(0xFF1976D2)) {
                    val parts = listOf(
                        Triple("1. Noun (संज्ञा)", "किसी व्यक्ति, स्थान या वस्तु के नाम को Noun कहते हैं ।", "Ram, Delhi, Book, Water."),
                        Triple("2. Pronoun (सर्वनाम)", "Noun के स्थान पर प्रयोग होने वाले शब्दों को Pronoun कहते हैं ।", "He, She, I, You, They."),
                        Triple("3. Verb (क्रिया)", "जिस शब्द से किसी कार्य के होने या करने का बोध हो ।", "Play, Go, Eat, Sleep."),
                        Triple("4. Adjective (विशेषण)", "जो Noun या Pronoun की विशेषता बतलाते हैं ।", "Good, Tall, Brave, Red."),
                        Triple("5. Adverb (क्रिया विशेषण)", "जो Verb, Adjective या दूसरे Adverb की विशेषता बतलाते हैं ।", "Slowly, Very, Well, Fast."),
                        Triple("6. Preposition (सम्बन्ध सूचक)", "जो शब्द Noun/Pronoun से पहले लगकर उनका सम्बन्ध दूसरे शब्दों से बताते हैं ।", "In, On, At, With, From."),
                        Triple("7. Conjunction (संयोजक)", "जो दो शब्दों या वाक्यों को आपस में जोड़ते हैं ।", "And, But, Or, Because."),
                        Triple("8. Interjection (विस्मय सूचक)", "जो मन के अचानक आने वाले भावों (हर्ष, शोक, आश्चर्य) को प्रकट करें ।", "Alas! Hurrah! Wow! Oh!")
                    )
                    
                    parts.forEachIndexed { index, (name, def, ex) ->
                        val bgColor = PointColors[index % PointColors.size]
                        Surface(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                            color = bgColor,
                            shape = MaterialTheme.shapes.small
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(name, fontWeight = FontWeight.Bold, color = Color(0xFF1976D2), fontSize = 16.sp)
                                Text(def, fontSize = 15.sp, color = Color.Black)
                                Text("Example: $ex", fontStyle = FontStyle.Italic, color = Color.DarkGray, fontSize = 14.sp)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Noun Kinds
                ContentSection(title = "Kinds of Noun (संज्ञा के भेद)", titleColor = Color(0xFF388E3C)) {
                    val kinds = listOf(
                        "1. Proper Noun (व्यक्तिवाचक संज्ञा): किसी विशेष नाम के लिए ।\nExample:\nRam, Ganga, India.",
                        "2. Common Noun (जातिवाचक संज्ञा): पूरी जाति का बोध कराने वाले शब्द ।\nExample:\nBoy, City, River, Book.",
                        "3. Collective Noun (समूहवाचक संज्ञा): समूह या झुंड का बोध कराने वाले शब्द ।\nExample:\nArmy, Class, Team, Crowd.",
                        "4. Material Noun (द्रव्यवाचक संज्ञा): धातु या पदार्थ का बोध कराने वाले शब्द ।\nExample:\nGold, Milk, Iron, Water.",
                        "5. Abstract Noun (भाववाचक संज्ञा): गुण, दशा या कार्य का बोध कराने वाले शब्द ।\nExample:\nHonesty, Love, Poverty, Truth."
                    )
                    kinds.forEachIndexed { index, it -> ColoredPoint(it, index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Number
                ContentSection(title = "Number (वचन)", titleColor = Color(0xFFF57C00)) {
                    Row(modifier = Modifier.padding(vertical = 8.dp)) {
                        BulletPoint("Singular (एक वचन)", Color.Black)
                        Spacer(modifier = Modifier.width(16.dp))
                        BulletPoint("Plural (बहुवचन)", Color.Black)
                    }
                    
                    SubSectionTitle("Rules for Singular to Plural :-", Color.Black)
                    val rules = listOf(
                        "1. अंत मे 's' जोड़कर ।\nExample:\nPen - Pens",
                        "2. अंत मे s, sh, ch, x हो तो 'es' जोड़कर ।\nExample:\nBox - Boxes",
                        "3. अंत मे y और पूर्व Consonant हो तो y हटाकर 'ies' जोड़कर ।\nExample:\nBaby - Babies",
                        "4. अंत मे f या fe हो तो हटाकर 'ves' जोड़कर ।\nExample:\nLeaf - Leaves",
                        "5. कुछ में स्वर (Vowel) बदलकर ।\nExample:\nFoot - Feet, Man - Men",
                        "6. Ox मे 'en' जोड़कर Oxen बनता है तथा Child मे 'ren' जोड़कर Children बनता है ।"
                    )
                    rules.forEachIndexed { index, it -> ColoredPoint(it, index + 5) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Gender
                ContentSection(title = "Gender (लिंग)", titleColor = Color(0xFF7B1FA2)) {
                    val genders = listOf(
                        "1. Masculine (पुल्लिंग): नर जाति के लिए । (Ex: Boy, King)",
                        "2. Feminine (स्त्रीलिंग): मादा जाति के लिए । (Ex: Girl, Queen)",
                        "3. Common (उभयलिंग): जो नर-मादा दोनों हो सकें । (Ex: Doctor, Teacher)",
                        "4. Neuter (नपुंसकलिंग): निर्जीव वस्तुओं के लिए । (Ex: Pen, Table)"
                    )
                    genders.forEachIndexed { index, it -> ColoredPoint(it, index) }
                }

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PartOfSpeechPreview() {
    GrammarTheme {
        PartOfSpeechContent()
    }
}
