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
fun DoublePartsContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
            // Header
            TopAppBar(
                title = { Text("Double Parts of Speech", fontWeight = FontWeight.Bold) },
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
                // Main Intro
                Text(
                    text = "Double Parts of Speech",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                val mainList = listOf("1. Infinitive", "2. Participle", "3. Gerund")
                mainList.forEachIndexed { index, s ->
                    ColoredPoint(text = s, index = index)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 1. Infinitive
                ContentSection(title = "1. Infinitive", titleColor = Color(0xFF1976D2)) {
                    Text(
                        text = "यह verb की first form के पहले 'To' लगाने से बनता है | यह दो प्रकार का होता है -",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    ColoredPoint("(i) Simple Infinitive", 0)
                    ColoredPoint("(ii) Gerundial Infinitive", 1)

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("(i). Simple Infinitive :-", Color(0xFF388E3C))
                    Text("इस के द्वारा sentences मे noun का कार्य 5 प्रकार से होता है -", fontSize = 15.sp, modifier = Modifier.padding(bottom = 8.dp))
                    
                    val simpleInfUses = listOf(
                        "a. subject to a verb.\nExample:\nTo sleep in the day time is harmful.",
                        "b. object to a verb.\nExample:\nShe likes to dance.",
                        "c. object to a preposition.\nExample:\nI am about to sleep.\n(मैं सोने वाला हूँ |)",
                        "d. complement to a verb.\nExample:\nI am to go to school.\n(मुझे स्कूल जाने को है |)",
                        "e. case in apposition.\nExample:\nIt is doubtful for me to go to school."
                    )
                    simpleInfUses.forEachIndexed { index, s -> ColoredPoint(s, index + 2) }

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("Rule :-", Color.Black)
                    Text("Infinitive मे verb से पहले 'To' लगा देते है कुछ verbs के बाद Infinitive 'to' छिपा रहता है |", fontSize = 14.sp)
                    ExampleItem("Example:", "He let me go.\n(उसने मुझे जाने दिया)")
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("निम्नलिखित verbs के साथ 'To' का प्रयोग नहीं होता है:", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("bid, behold, dare, let, make, need, please, see, feel, hear.", fontSize = 14.sp, color = Color.DarkGray)

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("(ii) Gerundial infinitive :-", Color(0xFF388E3C))
                    Text("इस के द्वारा adjective अथवा adverb का कार्य प्रकट किया जाता है | यह adjective की तरह किसी noun या pronoun को Qualify करता है, adverb की तरह किसी verb, adjective या दूसरे adverb को Modify करता है |", fontSize = 15.sp)
                    ExampleItem("Example:", "He was frightened to see the lion.\n(वह शेर देख कर डर गया)")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Participle
                ContentSection(title = "2. Participle", titleColor = Color(0xFFF57C00)) {
                    Text("यह verb का वह रूप है जो की verb तथा adjective दोनों का कार्य करता है | हिंदी अर्थ मे verb के अंत मे कर, कर के, करते हुए, करता हुआ आदि शब्द आते है |", fontSize = 16.sp)
                    Text("Participle 3 प्रकार का होता है -", fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 8.dp))
                    
                    val pTypes = listOf("(i) Present participle", "(ii) Past participle", "(iii) Perfect participle")
                    pTypes.forEachIndexed { index, s -> ColoredPoint(s, index) }

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("(i) Present participle :-", Color(0xFF1976D2))
                    Text("इस मे verb की first form मे ing का प्रयोग होता है और हिंदी वाक्यों मे verb के बाद कर तथा हुए शब्द आता है और वाक्य past या future tense मे होता है |", fontSize = 14.sp)
                    ExampleItem("Example:", "Turning to the left you will reach the temple.")

                    Spacer(modifier = Modifier.height(12.dp))
                    SubSectionTitle("(ii) Past participle :-", Color(0xFF1976D2))
                    Text("इस मे verb की third form का use complement की तरह होता है | यह present time की जानकारी देता है |", fontSize = 14.sp)
                    ExampleItem("Example:", "He is a retired teacher.")

                    Spacer(modifier = Modifier.height(12.dp))
                    SubSectionTitle("(iii) Perfect Participle :-", Color(0xFF1976D2))
                    Text("इस मे having के साथ verb का III form प्रयोग किया जाता है |", fontSize = 14.sp)
                    ExampleItem("Example:", "Having sold his old house Ram bought a new one.")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Gerund
                ContentSection(title = "3. Gerund", titleColor = Color(0xFF7B1FA2)) {
                    Text("इस के दो भाग होते है -", fontSize = 16.sp)
                    ColoredPoint("(i). The gerund", 3)
                    ColoredPoint("(ii). The verbal noun", 4)

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("(i) The Gerund :-", Color(0xFF388E3C))
                    Text("Rule: Gerund, verb मे ing लगा कर बनता है और यह noun का कार्य करता है |", fontSize = 14.sp)
                    Text("2. हिंदी अर्थ मे verb के अंत मे 'ना' आता है । (Example: टहलना, गाना) । Gerund sentence मे 4 तरह से कार्य करता है -", fontSize = 14.sp, modifier = Modifier.padding(vertical = 4.dp))
                    
                    val gUses = listOf(
                        "(a.) Subject to a verb - Walking is useful for health.",
                        "(b.) Object to a verb - She likes singing songs.",
                        "(c.) Object to a preposition - She is fond of dancing.",
                        "(d.) Complement to a verb - His habit was abusing others."
                    )
                    gUses.forEachIndexed { index, s -> ColoredPoint(s, index + 1) }

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("(ii) The verbal noun :-", Color(0xFF388E3C))
                    Text("Gerund और verbal noun दोनों देखने मे एक से होते है | कुछ विद्वानों के अनुसार इन मे अंतर इतना होता है कि verbal noun के पहले 'The' और बाद मे 'of' आता है जब की gerund मे नहीं होता |", fontSize = 14.sp)
                    ExampleItem("Example:", "The teaching of English is very difficult.")
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoublePartsPreview() {
    GrammarTheme {
        DoublePartsContent()
    }
}
