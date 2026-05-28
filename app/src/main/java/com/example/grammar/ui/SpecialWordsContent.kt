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
fun SpecialWordsContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
        color = backgroundColor,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Special Words Usage", fontWeight = FontWeight.Bold) },
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
                    text = "Special Words",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                Text(
                    text = "Uses of some special words that often cause confusion:",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // 1. Use of verb ‘To be’
                ContentSection(title = "use of verb ‘To be’- is, am, are, was, were", titleColor = Color(0xFF1976D2)) {
                    Text(
                        text = "Be verb के कुल 5 part है - is, am, are present tense मे तथा past tense मे was, were प्रयोग होते है ।",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("इन का प्रयोग निम्नलिखित है -", fontWeight = FontWeight.Bold, color = Color.Gray)
                    
                    Text("1. यह progressive tense बनाने मे प्रयोग होती है ।", fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp), color = Color.Black)
                    ExampleItem("Example:", "She is going to school.")

                    Text("2. passive voice बनाने मे ।", fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp), color = Color.Black)
                    ExampleItem("Example:", "School is being gone by her.")

                    Text("3. कुछ वाक्यों मे be verb helping verb नहीं बल्कि main verb के रुप मे काम करती है ।", fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp), color = Color.Black)
                    ExampleItem("Example:", "They are brave.\nIs he an honest man?")
                    
                    RuleBox("Note: be verb का progressive मे being तथा participle मे been होता है ।")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Introductory ‘It’
                ContentSection(title = "Use of introductory ‘It’", titleColor = Color(0xFF388E3C)) {
                    Text(
                        text = "जिन वाक्यों मे वास्तविक कर्ता न हो उन वाक्यों मे subject के स्थान पर It का प्रयोग होता है । जिन वाक्यों मे समय, दिन, मौसम, वर्षा, प्राकृतिक घटना का वर्णन हो अथवा बात पर जोर दिया जाये तो उन्हें It से प्रारंभ करते है ।",
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ExampleItem("Example:", "It is 6 o’clock. (समय)\nIt is Sunday today. (दिन)\nIt is hot today. (मौसम)\nIt is raining heavily. (वर्षा)\nIt is growing dark. (प्राकृतिक घटना)\nIt was I who did this work. (जोर, बल)")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Use of have
                ContentSection(title = "Use of have", titleColor = Color(0xFFF57C00)) {
                    Text("इस verb के निम् use है -", fontWeight = FontWeight.Medium, color = Color.Black)
                    
                    Text("1. इस का प्रयोग perfect tense बनाने मे किया जाता है ।", fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp), color = Color.Black)
                    ExampleItem("Example:", "He has eaten a mango.")

                    Text("2. जब verb का अर्थ किसी वस्तु को अधिकार मे रखना हो तो इस अर्थ मे वह मुख्य क्रिया होती है । इस लिए इस क्रिया के Negative तथा Interrogative मे प्रायः do, does, did का प्रयोग होता है ।", fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp), color = Color.Black)
                    ExampleItem("Example:", "I have a pen.\nI had a pen.\nDoes he have much money?")
                    
                    RuleBox("Note: वाक्य मे tense एवं कर्ता के अनुसार has, have, had, will have, shall have का प्रयोग होता है ।")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Introductory ‘There’
                ContentSection(title = "Use of introductory ‘There’", titleColor = Color(0xFF7B1FA2)) {
                    Text(
                        text = "जिन वाक्यों मे किसी बात का होना या न होना पाया जाये और प्रकृतिक घटना न हो तो ऐसे वाक्यों को There से प्रारंभ करते है । जो शब्द subject या object का कार्य करते है उन्हें verb के बाद रखते है इन मे There का कोई अर्थ नहीं होता । There के बाद verb बहुधा is, am, was, were का use होता है । कभी कभी There के साथ will be, shall be तथा past indefinite tense मे भी use होता है ।",
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ExampleItem("Example:", "1. There are fifty boys in my class\n2. Were there players in the field?\n3. Once there was a cruel king.\n4. There lived an old man in a village.\n5. There will be no meeting in the hall.")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. ‘Have’ + ‘To’ infinitive
                ContentSection(title = "Use of ‘Have’ + ‘To’ infinitive", titleColor = Color(0xFFC62828)) {
                    Text(
                        text = "Main verb से पहले present tense मे has to, have to तथा past tense मे had to का प्रयोग होता है तो उन हिंदी वाक्यों का अर्थ पड़ा, पड़ी, पड़े, पड़ता है, बढ़ती है, पड़ते है अथवा मज़बूरी प्रकट होती है ।",
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ExampleItem("Example:", "उसे जाना पड़ता है ।\nHe has to go.\n\nक्या आप को प्रतिदिन सुबह 4 बजे उठना पड़ता था ?\nDid you have to get up at 4am daily?")
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpecialWordsPreview() {
    GrammarTheme {
        SpecialWordsContent()
    }
}
