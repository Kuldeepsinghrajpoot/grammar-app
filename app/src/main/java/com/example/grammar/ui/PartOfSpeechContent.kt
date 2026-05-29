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
                    text = "Grammar के अनुसार शब्दो को 8 भागों मे बाँटा जाता है जिन्हे parts of Speech (शब्दो के भेद) कहते है -",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // 1. Definitions
                ContentSection(title = "1. Definitions & Examples", titleColor = Color(0xFF1976D2)) {
                    val parts = listOf(
                        Triple("1. Noun (संज्ञा)", "A noun is the name of a person, place or thing.", "Ram, Nowgong."),
                        Triple("2. Pronoun (सर्वनाम)", "A pronoun is a word used instead of a noun.", "He, She, it."),
                        Triple("3. Verb (क्रिया)", "A verb is a word that says something.", "Come, go."),
                        Triple("4. Adjective (विशेषण)", "An Adjective Qualifies a noun or a pronoun.", "Beautiful, Good."),
                        Triple("5. Adverb (क्रिया विशेषण)", "An adverb modifies a verb, adjective or another adverb.\n(क्रिया विशेषण वह है जो किसी verb, विशेषण या किसी अन्य क्रिया विशेषण की विशेषता प्रकट करते है |)", "Very, Slowly, Too, Fast."),
                        Triple("6. Preposition (सम्बन्ध बोधक)", "Preposition is a word placed before a noun or pronoun to show its relation with some other words.", "At, On, With, From, To, Into."),
                        Triple("7. Conjunction (संयोजक)", "Conjunction is word which joins words, clauses or sentences with each other.", "And, But, Or, Because, Either… Or, Neither… Nor."),
                        Triple("8. Interjection (विस्मय वोधक)", "An interjection expresses the strong feeling of joy, hate, sorrow, wonder etc.", "Alas! Hurrah! Oh!")
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
                                if (ex.isNotEmpty()) {
                                    Text("Example: $ex", fontStyle = FontStyle.Italic, color = Color.DarkGray, fontSize = 14.sp)
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Noun Kinds
                ContentSection(title = "Kinds of Noun (संज्ञा के भेद)", titleColor = Color(0xFF388E3C)) {
                    Text("Nouns have five kinds:", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp), color = Color.Black)
                    val kinds = listOf(
                        "1. Proper Noun (व्यक्ति वाचक संज्ञा)",
                        "2. Common noun (जाति वाचक संज्ञा)",
                        "3. Collective noun (समूह वाचक संज्ञा)",
                        "4. Material Noun (पदार्थ वाचक संज्ञा)",
                        "5. Abstract Noun (भाव वाचक संज्ञा)"
                    )
                    kinds.forEachIndexed { index, it -> ColoredPoint(it, index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Number
                ContentSection(title = "Number (वचन)", titleColor = Color(0xFFF57C00)) {
                    Text("अंग्रेजी भाषा मे number two प्रकार के होते है:", fontSize = 16.sp, color = Color.Black)
                    Row(modifier = Modifier.padding(vertical = 8.dp)) {
                        BulletPoint("1. Singular (एक वचन)", Color.Black)
                        Spacer(modifier = Modifier.width(16.dp))
                        BulletPoint("2. Plural (बहुवचन)", Color.Black)
                    }
                    
                    SubSectionTitle("Change into singular to plural :-", Color.Black)
                    val rules = listOf(
                        "1. अधिकांश शब्दों के अंत मे s लगा कर singular से plural बनाते है ।\nExample:\nBook - Books",
                        "2. जिन शब्दो के अंत मे s, ss, sh, ch, o तथा x आया हो उन मे es लगाकर बहुवचन बनाते है ।\nExample:\nClass - Classes",
                        "3. जिन शब्दो के अंत मे y आया हो तथा y से पूर्व कोई एक consonant आया हो तो बहुवचन बनाते समय y को i मे बदल कर es लगा देते है ।\nExample:\nStory - Stories",
                        "4. जिन शब्दो के अंत मे y हो तथा y से पहले कोई एक vowel हो तो plural बनाते समय y नहीं हटाते है और अंत मे s लगा देते है ।\nExample:\nKey - Keys",
                        "5. जिन शब्दों के अंत मे f या fe आया हो तो plural बनाते समय f या fe को हटा कर ves कर देते है ।\nExample:\nCalf - Calves",
                        "6. जिन शब्दों के अंत मे f या fe आया हो तथा f या fe के पूर्व एक जैसे double vowel आये हो तो plural बनाते समय f या fe को नहीं हटते है और s जोड़ देते है ।\nExample:\nProof - proofs",
                        "7. जिन शब्दों के अंत मे eo, io, yo, oo आया हो उन शब्दों का plural बनाने के लिए शब्द के अंत मे s लगा देते है ।\nExample:\nBamboo - Bamboos",
                        "8. कुछ शब्दों के अंत मे en या ren लगा कर plural बनाते है ।\nExample:\nOx - Oxen\nChild - Children",
                        "9. कुछ संज्ञाओं के Singular से plural अलग-अलग बनते है इन मे अक्षर बदले जाते है ।\nExample:\nMan - Men\nMouse - Mice",
                        "10. जो संज्ञा दो या दो से अधिक शब्दों से मिलकर बनी हो तो संज्ञाओ का plural बनाने के लिए मुख्य शब्द के अंत मे s लगाते है ।\nExample:\nFather-in-law = Fathers-in-law",
                        "11. कुछ संज्ञाएँ singular और plural दोनो स्थिति मे एक जैसी रहती है ।\nExample:\nSheep\nFish\nDeer",
                        "12. कुछ संज्ञाओं का प्रयोग हमेशा बहुवचन मे किया जाता है ।\nExample:\nPeople\nCattle\nFolk",
                        "13. कुछ संज्ञाएँ देखने मे तो बहुवचन है लेकिन उन का प्रयोग हमेशा एक वचन मे होता है ।\nExample:\nNews\nMathematics\nPhysics",
                        "14. संख्या का plural बनाने के लिए संख्या मे Apostrophe ('s) लगाते है ।\nExample:\n7 - 7's"
                    )
                    rules.forEachIndexed { index, it -> ColoredPoint(it, index + 5) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Gender
                ContentSection(title = "Gender (लिंग)", titleColor = Color(0xFF7B1FA2)) {
                    Text("Gender चार प्रकार के होते है -", fontSize = 15.sp, color = Color.Black)
                    val genders = listOf(
                        "1. Masculine Gender (पुलिंग): जो संज्ञा नर जाति को दर्शाती है ।\nExample:\nMan, Boy, King",
                        "2. Feminine Gender (स्त्री लिंग): वे संज्ञाएँ जो स्त्री जाति का बोध कराती है ।\nExample:\nGirl, Women, Queen",
                        "3. Neuter Gender (नपुंसक लिंग): वे संज्ञाए जो अचेतन पदार्थ हेतु या वे जिन मे जान नहीं होती है ।\nExample:\nStone, Book, Pen",
                        "4. Common Gender (उभय लिंग): वे संज्ञाएँ जो पुरुष एवं स्त्री दोनों के लिए उपयोग मे लायी जाती है ।\nExample:\nBaby, Parents"
                    )
                    genders.forEachIndexed { index, it -> ColoredPoint(it, index) }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("Masculine से Feminine मे बदलने के नियम :-", Color.Black)
                    
                    Text("Rule 1: पूर्ण रूप से शब्द परिवर्तन", fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(vertical = 4.dp))
                    GenderTable(listOf(
                        "Boy" to "Girl", "King" to "Queen", "Father" to "Mother", "Uncle" to "Aunt", 
                        "Sir" to "Madam", "Cock" to "Hen", "Dog" to "Bitch", "Son" to "Daughter", "Bull" to "Cow"
                    ))
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Rule 2: ess और ss लगा कर", fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(vertical = 4.dp))
                    GenderTable(listOf(
                        "Prince" to "Princess", "Poet" to "Poetess", "Lion" to "Lioness", "God" to "Goddess"
                    ))
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Rule 3: Consonant के पूर्व vowel हटा कर अंत मे ess जोड़ कर", fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(vertical = 4.dp))
                    GenderTable(listOf(
                        "Actor" to "Actress", "Master" to "Mistress", "Tiger" to "Tigress", "Emperor" to "Empress"
                    ))
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Rule 4: मुख्य शब्द मे परिवर्तन कर", fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(vertical = 4.dp))
                    GenderTable(listOf(
                        "Grand-Father" to "Grand-Mother", "Peacock" to "Peahen", "He-Goat" to "She-Goat"
                    ))
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Rule 5: अंत मे ine या a जोड़कर", fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(vertical = 4.dp))
                    GenderTable(listOf(
                        "Hero" to "Heroine", "Sultan" to "Sultana"
                    ))
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Case
                ContentSection(title = "Case (कारक)", titleColor = Color(0xFF1976D2)) {
                    Text("Case चार प्रकार के होते है:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                    val cases = listOf(
                        "1. Nominative Case (कर्ता कारक)\nExample:\nRam is playing.", 
                        "2. Objective Case (कर्म कारक)\nExample:\nHe likes mangoes.", 
                        "3. Possessive Case (सम्बन्ध कारक)\nExample:\nThis is Mohan's house.", 
                        "4. Vocative Case (सम्बोधन कारक)\nExample:\nCome here, Sita."
                    )
                    cases.forEachIndexed { index, it -> ColoredPoint(it, index + 2) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Pronoun Types
                ContentSection(title = "Pronoun (सर्वनाम)", titleColor = Color(0xFF388E3C)) {
                    Text("Pronoun 9 प्रकार के होते है:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                    val pronouns = listOf(
                        "1. Personal Pronoun (व्यक्ति वाचक सर्वनाम) - I, We, You, He, She, It, They.",
                        "2. Demonstrative Pronoun (संकेत वाचक सर्वनाम) - This, That, These, Those.",
                        "3. Relative Pronoun (सम्बंद वाचक सर्वनाम) - Who, Whom, Whose, Which, That.",
                        "4. Interrogative Pronoun (प्रश्न वाचक सर्वनाम) - Who, Which, What, Whom.",
                        "5. Indefinite Pronoun (अनिश्चय वाचक सर्वनाम) - One, Some, Any, All, None.",
                        "6. Distributive Pronoun (विभाग वाचक सर्वनाम) - Each, Either, Neither.",
                        "7. Reflexive Pronoun (निज वाचक सर्वनाम) - Myself, Yourself, Himself.",
                        "8. Emphatic Pronoun (निश्चय वाचक सर्वनाम) - Myself, Yourself (Used for emphasis).",
                        "9. Exclamatory Pronoun (विसमय बोधक सर्वनाम) - What!"
                    )
                    pronouns.forEachIndexed { index, it -> ColoredPoint(it, index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 7. Adjective and Degrees
                ContentSection(title = "Comparison of Adjective (Degrees)", titleColor = Color(0xFFC62828)) {
                    Text("विशेषण तीन प्रकार के होते है जिन्हे हम Degree के नाम से जानते है -", fontSize = 15.sp, color = Color.Black)
                    val degs = listOf(
                        "1. Positive Degree: साधारण गुण का बोध । (so...as / as...as)",
                        "2. Comparative Degree: दो की तुलना । (Than)",
                        "3. Superlative Degree: सर्वाधिक गुण होने का बोध । (The)"
                    )
                    degs.forEachIndexed { index, it -> ColoredPoint(it, index + 3) }
                    
                    Spacer(modifier = Modifier.height(14.dp))
                    SubSectionTitle("Rules for changing Degrees :-", Color.Black)
                    
                    DegreeRuleSection("1. single syllable शब्द के अंत मे er तथा est जोड़ कर", listOf(
                        listOf("Bold", "Bolder", "Boldest"), listOf("Cold", "Colder", "Coldest"), listOf("High", "Higher", "Highest")
                    ))
                    
                    DegreeRuleSection("2. यदि अंत मे e लगा हो तो r तथा st लगा कर", listOf(
                        listOf("Fine", "Finer", "Finest"), listOf("Large", "Larger", "Largest"), listOf("Wise", "Wiser", "Wisest")
                    ))
                    
                    DegreeRuleSection("3. यदि अंत मे y हो और पूर्व consonant हो तो y हटा कर ier, iest जोड़ कर", listOf(
                        listOf("Happy", "Happier", "Happiest"), listOf("Easy", "Easier", "Easiest")
                    ))
                    
                    DegreeRuleSection("4. यदि अंत मे consonant हो और पूर्व vowel हो तो अंतिम अक्षर double कर er, est जोड़ कर", listOf(
                        listOf("Big", "Bigger", "Biggest"), listOf("Fat", "Fatter", "Fattest"), listOf("Thin", "Thinner", "Thinnest")
                    ))
                    
                    DegreeRuleSection("5. Double/Triple syllable शब्दों के पूर्व More तथा Most लगा कर", listOf(
                        listOf("Beautiful", "More Beautiful", "Most Beautiful"), listOf("Careful", "More careful", "Most careful")
                    ))
                    
                    DegreeRuleSection("6. कुछ शब्दों की degree अलग - अलग बनती है", listOf(
                        listOf("Good", "Better", "Best"), listOf("Bad", "Worse", "Worst"), listOf("Little", "Less", "Least")
                    ))
                }

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun GenderTable(pairs: List<Pair<String, String>>) {
    val borderColor = Color(0xFFCFD8DC)
    Column(modifier = Modifier.border(1.dp, borderColor).fillMaxWidth()) {
        Row(modifier = Modifier.background(Color(0xFF2C3E50)).fillMaxWidth()) {
            TableCellText("Masculine", weight = 1f, isHeader = true)
            TableCellText("Feminine", weight = 1f, isHeader = true)
        }
        pairs.forEachIndexed { index, pair ->
            val bgColor = if (index % 2 == 0) Color.White else Color(0xFFECEFF1)
            Row(modifier = Modifier.background(bgColor).fillMaxWidth()) {
                TableCellText(pair.first, weight = 1f)
                TableCellText(pair.second, weight = 1f)
            }
        }
    }
}

@Composable
fun DegreeRuleSection(rule: String, rows: List<List<String>>) {
    Column(modifier = Modifier.padding(top = 12.dp)) {
        Text(rule, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFF455A64))
        Spacer(modifier = Modifier.height(4.dp))
        val borderColor = Color(0xFFCFD8DC)
        Column(modifier = Modifier.border(1.dp, borderColor).fillMaxWidth()) {
            Row(modifier = Modifier.background(Color(0xFF263238)).fillMaxWidth()) {
                TableCellText("Positive", weight = 1f, isHeader = true)
                TableCellText("Comparative", weight = 1f, isHeader = true)
                TableCellText("Superlative", weight = 1f, isHeader = true)
            }
            rows.forEachIndexed { index, row ->
                val bgColor = if (index % 2 == 0) Color.White else Color(0xFFF1F8E9)
                Row(modifier = Modifier.background(bgColor).fillMaxWidth()) {
                    row.forEach { text -> TableCellText(text, weight = 1f) }
                }
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
