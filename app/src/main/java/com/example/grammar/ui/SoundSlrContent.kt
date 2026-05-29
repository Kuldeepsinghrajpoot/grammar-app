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
fun SoundSlrContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
                title = { Text("LSR Relationship", fontWeight = FontWeight.Bold) },
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
                    text = "LSR-Letter Sound Relationship",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                ContentSection(title = "Understanding LSR", titleColor = Color(0xFF1976D2)) {
                    Text(
                        text = "Q. LSR को प्रश्नों द्वारा समझते है| Whose LSR and how LSR ?\nइस का answer है - तीन sound group का LSR समझना -",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    
                    val groups = listOf(
                        "1. Vowel - E,L,H,S",
                        "2. Consonant - H,S,E,L",
                        "3. भारतीय sound - B-S,E,L"
                    )
                    groups.forEachIndexed { index, group ->
                        ColoredPoint(text = group, index = index)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 1. Vowel Section
                ContentSection(title = "1. Vowel E,L,H,S:-", titleColor = Color(0xFF388E3C)) {
                    val vowels = listOf(
                        "A - अ - about, आ - ask, ऑ - call, ए - any, ऐ - cat, एअ - care",
                        "E - अ - earn, आ - eye, इ - because, ई - eat, ए - bet.",
                        "I - अ - first, इ - sit, आइ - right, आइअ - fire (फाइअर)",
                        "O - अ - son, ऑ - on, ओ - go, ऊ - do, oo - उ / ऊ - good, boon.",
                        "U - अ - up, ऊ - Rule, यू - unit, उ - put."
                    )
                    vowels.forEachIndexed { index, vowel ->
                        ColoredPoint(text = vowel, index = index + 3)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Consonant Section
                ContentSection(title = "2. Consonant", titleColor = Color(0xFFF57C00)) {
                    val cTypes = listOf(
                        "1. Single letter single sound.",
                        "2. Single Hindi letter English many sounds."
                    )
                    cTypes.forEachIndexed { index, type -> ColoredPoint(text = type, index = index) }

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("1. Single letter single sound H,S,E,L :-", Color(0xFF1976D2))
                    Text("ये हिंदी के 16 letter होते है -", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    
                    val letters = listOf(
                        "प\nP - paste, spot", "ब\nB - back, bake", "ट\nT - Time, table",
                        "ड\nD - Day, Daily", "ग\nG - Bag, game, gun", "ह\nH - Habit, Hand",
                        "म\nM - Man, Moon, mix", "न\nN - Name, Nail, Nil", "ल\nL - Life, Left",
                        "र\nR - Round, Rule", "य\nY - Yes, Year", "थ\nTh - Both, Path",
                        "द\nTh - This, Those", "ड़\nIng - King, Ring", "ग्ज\nx - Exam, Example",
                        "क्स\nX - Fox, Extra"
                    )
                    letters.chunked(2).forEach { row ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            row.forEach { item ->
                                Text("• $item", modifier = Modifier.weight(1f), fontSize = 14.sp, color = Color.Black)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                ContentSection(title = "2. Single Hindi letter English many sounds.", titleColor = Color(0xFF7B1FA2)) {
                    Text("ये letter हिंदी मे 7 होते है जो english के दो या दो से अधिक letter से बनते है -", fontSize = 15.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    val complexSounds = listOf(
                        "च\nch / T - change, chain, Nature, Future.",
                        "स\nS / C - Safe, Sound, Ice, Nice.",
                        "क\nc - call, cat, college / k - kite, kind, knife, keep / ch - chemical, school, character / ck - back, crack.",
                        "फ\nF - fan, far, fail, family / Ph - photo, physics, phone / Gh - Cough, Enough, laugh.",
                        "व\nV - Van, cave, save / W - wait, well, win / O - One, once.",
                        "श\nSh - shape, Sharp, push / Ch - Machine, Chiffon / T - Action, Condition, Function.",
                        "ज\nG - Age, cage, Page / J - Jug, Just, Joke / S - Present (प्रेजन्ट), Rose, pose / Z - Zoo, Zero, Zoom / X - Xerox, Xylem"
                    )
                    complexSounds.forEachIndexed { index, it -> 
                        ColoredPoint(text = it, index = index)
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    RuleBox("Note:- आधा अक्षर के लिए वही letter आता है जो पूरे अक्षर के लिए आता है ।\nExample:- स् - s = school, smile")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. B-SEL Section
                ContentSection(title = "3. B-SEL - Bhartiya Sound English Letter/s", titleColor = Color(0xFF388E3C)) {
                    Text("Use:- इस का use सिर्फ हिंदी words की Spelling लिखने के लिए होता है -", fontSize = 14.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(12.dp))
                    BselFullGrid()
                    Text("Note :- ये letter 21 होते है ।", fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp), color = Color.Black)
                }

                Spacer(modifier = Modifier.height(16.dp))
                ContentSection(title = "Silent Letter :-", titleColor = Color(0xFFC62828)) {
                    ColoredPoint("वे letter जो लिखे तो जाते है लेकिन बोले नहीं जाते है - Example: Walk, know, right.", 4)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Why LSR Section
                ContentSection(title = "Why LSR Than Barah Khadi?", titleColor = Color(0xFF1976D2)) {
                    Text("Question: बारह खड़ी से spelling गलत क्यों हो जाती है ?", fontWeight = FontWeight.Bold, color = Color(0xFFB71C1C))
                    Text("Answer: बारह खड़ी से one to one Relationship (one letter one sound) द्वारा सीखते है । Example: A - अ, E - ए, k - क।", fontSize = 14.sp, color = Color.Black)
                    Text("जब की English मे अधिकांश letter के लिए one to many relationship (one letter many sound) होता है ।", fontSize = 14.sp, color = Color.Black)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Example: A - अ, आ, इ, ए, ऐ", fontSize = 14.sp, color = Color.DarkGray)
                    Text("क - c, k, ch, ck", fontSize = 14.sp, color = Color.DarkGray)
                    Text("फ - F, Ph, Gh", fontSize = 14.sp, color = Color.DarkGray)

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("क्या हिंदी शब्दों की तरह English words की Spelling भी अपने मन से बना कर लिख सकते है ?", fontWeight = FontWeight.Bold, color = Color(0xFFB71C1C))
                    Text("नहीं ! इसके तीन मुख्य कारण है -", fontSize = 14.sp, color = Color.Black)
                    
                    val negPoints = listOf(
                        "1. हिंदी मे one to one relation होता है जबकि english मे one to many relation होता है ।",
                        "2. बारह खड़ी से लिखने पर Spelling प्रायः गलत होती है और उच्चारण भी गलत हो जाता है ।\nExample:\ndate - डाटे\nSir - सिर\nkite - किटे",
                        "3. Word-based pronunciation: English मे letter का pronunciation कई शब्दो मे बदल भी जाता है ।\nExample:\nbus - बस\nbush - बुश\nthough - दो\nthought - थोट\nhe - ही\nher - हर"
                    )
                    negPoints.forEachIndexed { index, point ->
                        ColoredPoint(text = point, index = index + 1)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Question: letter sound difference क्या है?", fontWeight = FontWeight.Bold, color = Color(0xFFB71C1C))
                    Text("Answer: A,B,C,D (Alphabet) को जब लिखा जाता है तब उसे letter कहते है, और जब उसे सुना या बोला जाता है तब उसे sound कहते है ।", fontSize = 14.sp, color = Color.Black)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // V F.M Section
                ContentSection(title = "V F.M (Verb form Meaning)", titleColor = Color(0xFF7B1FA2)) {
                    Text("learning point :- First, Second, Third, S form, W I N - R I L", fontSize = 14.sp, color = Color.Gray)
                    Text("किसी भी verb की five form होती है लेकिन प्रयोग की दृस्टी से इस का प्रयोग 11 प्रकार से कर सकते है :", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(vertical = 8.dp))
                    
                    VerbFormMeaningTable()
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("Hindi ID :-", Color.Black)
                    val hindiIds = listOf(
                        "1. Verb Meaning - ना\n(Example: Sit - बैठना)",
                        "2. Imperative M - ना, ओ\n(Example: Sit - बैठो)",
                        "3. S - Form meaning - ता है, ती है, ते है\n(Example: Sits - बैठता)"
                    )
                    hindiIds.forEachIndexed { index, s -> ColoredPoint(s, index) }
                }
                
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun BselFullGrid() {
    val borderColor = Color(0xFFA5D6A7)
    val gridData = listOf(
        listOf("औ - Au", "अं - An", "अ: - Ah", "ऋ - Ri", "त - T", "घ - Gh", "ङ - N"),
        listOf("छ - chh", "झ - jh", "ञ - N", "ख़ - Kh", "ठ - Th", "ढ़ - Dh", "ण - N"),
        listOf("भ - Bh", "श - Sh", "ष - sh", "क्ष - Ksh", "त्र - Tr", "ज्ञ - Gya", "श्र - Shr")
    )

    Column(modifier = Modifier.border(1.dp, borderColor)) {
        gridData.forEach { row ->
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {
                row.forEach { item ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(0.5.dp, borderColor)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item,
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B5E20),
                            lineHeight = 13.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VerbFormMeaningTable() {
    val borderColor = Color(0xFFB0BEC5)
    val headerColor = Color(0xFF37474F)
    
    val rows = listOf(
        listOf("01", "First Form", "V-1", "Go", "जाना |"),
        listOf("02", "Second Form", "v-2(2nd Form)", "Went", "चला गया |"),
        listOf("03", "Third Form", "V-3(3rd Form)", "Gone(has)", "चला गया है |"),
        listOf("04", "Ing Form", "V-ing Form", "Going", "जा रहा |"),
        listOf("05", "S Form", "V-1+S Form", "Goes", "जाता है |"),
        listOf("06", "Will Form", "Will + V-1", "Will go", "जायेगा |"),
        listOf("07", "Imperative", "V-1(1st Form)", "Go", "जाओ |"),
        listOf("08", "Negative Impe.", "Don’t+ V-1", "Don’t go", "मत जाओ |"),
        listOf("09", "Infinitive", "To + V-1", "To go", "जाने के लिए |"),
        listOf("10", "Let Form", "Let + V-1", "Let go", "जाने दो |"),
        listOf("11", "Receiver", "Be + V-3", "is played", "खेलते है |")
    )

    Column(modifier = Modifier.fillMaxWidth().border(1.dp, borderColor)) {
        // Header
        Row(modifier = Modifier.background(headerColor).fillMaxWidth().height(IntrinsicSize.Max)) {
            val headers = listOf("SN", "Verb Form", "Structure", "Example", "Meaning")
            headers.forEachIndexed { index, s ->
                val weight = when(index) {
                    0 -> 0.4f
                    1 -> 1.1f
                    2 -> 1.1f
                    3 -> 0.8f
                    else -> 1.1f
                }
                Box(
                    modifier = Modifier
                        .weight(weight)
                        .fillMaxHeight()
                        .border(0.5.dp, borderColor.copy(alpha = 0.5f))
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(s, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                }
            }
        }

        // Data Rows
        rows.forEachIndexed { rowIndex, row ->
            val bgColor = if (rowIndex % 2 == 0) Color.White else Color(0xFFF5F7F8)
            Row(modifier = Modifier.background(bgColor).fillMaxWidth().height(IntrinsicSize.Max)) {
                row.forEachIndexed { index, s ->
                    val weight = when(index) {
                        0 -> 0.4f
                        1 -> 1.1f
                        2 -> 1.1f
                        3 -> 0.8f
                        else -> 1.1f
                    }
                    Box(
                        modifier = Modifier
                            .weight(weight)
                            .fillMaxHeight()
                            .border(0.5.dp, borderColor.copy(alpha = 0.3f))
                            .padding(4.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = s,
                            color = Color.Black,
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            textAlign = if (index == 0) TextAlign.Center else TextAlign.Start
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SoundSlrPreview() {
    GrammarTheme {
        SoundSlrContent()
    }
}
