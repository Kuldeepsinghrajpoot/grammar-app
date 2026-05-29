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
fun ArticleContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
                title = { Text("The Article", fontWeight = FontWeight.Bold) },
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
                    text = "The Article",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )

                Text(
                    text = "English मे A, An, The को आर्टिकल कहते हैं | ये दो type के होते है |",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Types of Article in a Card Box
                ContentSection(title = "Types of Article", titleColor = Color(0xFFD32F2F)) {
                    Column(modifier = Modifier.padding(vertical = 4.dp)) {
                        BulletPoint("1. Indefinite Article", Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                        BulletPoint("2. Definite Article", Color.Black)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 1. Indefinite Article
                ContentSection(title = "1. Indefinite Article", titleColor = Color(0xFF1976D2)) {
                    ColoredPoint("A तथा An को Indefinite कहा जाता है क्योंकि ये अनिश्चित noun के पहले आते है। इनका प्रयोग केवल Singular Countable के साथ होता है| Uncountable के साथ इस article का प्रयोग नहीं किया जाता है।", 0)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    RuleBox("Example:\nA chair is made of wood.\n(इस वाक्य मैं chair countable हैं जब की wood Uncountable हैं|)")

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("Use of A", Color.Black)
                    val useOfA = listOf(
                        "उन Noun के पहले जिसकी गिनती की जा सकती है, और उच्चारण Consonant जैसा हो या consonant की आवाज़ से हो |\nExample:\nA dog, A horse.",
                        "जब U की आवाज़ 'यू' हो |\nExample:\nA university.",
                        "जब ‘O’ की आवाज़ 'व' हो |\nExample:\nA one eyed man."
                    )
                    useOfA.forEachIndexed { index, text -> ColoredPoint(text, index + 1) }

                    Spacer(modifier = Modifier.height(16.dp))
                    SubSectionTitle("Use of An", Color.Black)
                    val useOfAn = listOf(
                        "उन शब्दों के पहले जो किसी vowel से प्रारम्भ हुए हों |\nExample:\nAn ass, An orange.",
                        "जिन शब्दों में ‘H’ Silent रहता है उसके पहले An का प्रयोग होता है|\nExample:\nAn Hour, An Honest.",
                        "जिन short form वाले शब्द जिनका उच्चारण vowel जैसा हो, के पूर्व An का प्रयोग होता हैं वे अक्षर निम्न हैं: F, L, M, N, O, S."
                    )
                    useOfAn.forEachIndexed { index, text -> ColoredPoint(text, index + 4) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Definite Article
                ContentSection(title = "2. Definite Article", titleColor = Color(0xFF388E3C)) {
                    ArticlePronunciation()

                    Spacer(modifier = Modifier.height(12.dp))
                    val theRules = listOf(
                        "1. The का प्रयोग उस समय होता है जब किसी प्राणी या वस्तु अथवा जिसका पहले उल्लेख हो चुका हो या जिससे वक्ता परिचित हो, के बारे मे बात करते हैं |\nExample:\nI saw a boy. The boy was very tall.\n(मैंने एक लड़का देखा। वह लड़का बहुत लंबा था।)",
                        "2. प्राकृतिक सम्पदा जैसे नदी, पहाड़, समुद्र, रेगिस्तान आदि कुछ देश प्रांत भौगोलिक नाम के पहले लगाते हैं |\nExample:\nThe Ganges, The Himalayas, The Pacific Ocean, The Sahara.",
                        "3. एक वचन common noun जब वे समस्त जाति के लिए हों |\nExample:\nThe dog is a faithful animal.\n(कुत्ता एक वफादार जानवर होता है।)",
                        "4. धार्मिक ग्रंथों, चारों दिशाओं, कुछ वस्तुये जो केवल संसार मे एक हो, Superlative Degree, मुख्य घटनाये समाचार पत्रों प्रसिद्ध इमारतों, आवागमन के साधन के पूर्व करते हैं |\nExample:\nThe Ramayana, The East, The Sun, The Best, The Taj Mahal, The Rajdhani Express.",
                        "5. Adjective से पहले The का प्रयोग होता है| जब वह Noun की तरह प्रयोग होता है और उस adjective के बाद कोई noun नहीं आता है |\nExample:\nThe rich are not always kind.\n(अमीर हमेशा दयालु नहीं होते।)",
                        "6. All और Both के पश्चात तथा Whole के पूर्व 'The' का प्रयोग होता है |\nExample:\nAll the boys are present.\nBoth the brothers are honest.\nThe whole world is beautiful.",
                        "7. देशों के नामों के पूर्व 'The' लगने से वहाँ के व्यक्तियों का बोध होता है तथा प्रयोग न होने से उस शब्द से उस देश की भाषा का बोध होता है |\nExample:\nThe English\n(अँग्रेज़)\n\nEnglish\n(भाषा)"
                    )
                    theRules.forEachIndexed { index, text -> ColoredPoint(text, index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // No use of Article
                ContentSection(title = "No use of Article", titleColor = Color(0xFFC62828)) {
                    val noArticleRules = listOf(
                        "1. Proper noun के पहले प्रायः किसी भी Article का प्रयोग नहीं होता है |\nExample:\nDelhi is a big city.\n(The Delhi is a big city. - Wrong)",
                        "2. Material Noun के पहले 'The' का use नहीं होता है|\nExample:\nIron is a useful metal.\n(The iron is a useful metal. - Wrong)",
                        "3. Abstract noun के पहले 'the' का use नहीं होता है|\nExample:\nHonesty is the best policy.\n(The Honesty is the best policy. - Wrong)",
                        "4. जब कोई common noun विस्तृत अर्थ मे use हो तो Article नहीं आता है |\nExample:\nMan is mortal.\n(A man is mortal. - Wrong)",
                        "5. पद सहित नामों के पहले कोई Article का use नहीं होता है |\nExample:\nking Ashok.\n(The king Ashok. - Wrong)",
                        "6. kind of word के बाद आने वाले nouns के पहले कोई article नहीं लगता है |\nExample:\nWhat kind of man is he?\n(What kind of a man is he? - Wrong)",
                        "7. बीमारियों, Regular meals और उन वस्तुओं के पहले जो अपनी किस्म की एक है, किसी भी Article का use नहीं होता है |\nExample:\nFever, Malaria"
                    )
                    noArticleRules.forEachIndexed { index, text -> ColoredPoint(text, index + 3) }

                    Spacer(modifier = Modifier.height(12.dp))
                    RuleBox("Note:\n1. केवल two बीमारियों के पूर्व आर्टिकल का use होता है: The measles (खसरा), The mumps (कंठमाला का रोग).\n2. Breakfast, Lunch, Dinner.\n3. Hell, Heaven, God (The devil को छोड़ कर) जिस की कल्पना की जा सके |")

                    Spacer(modifier = Modifier.height(16.dp))
                    val additionalRules = listOf(
                        "8. उन Nouns के पहले जो देखने मे Singular हैं, लेकिन sense मे Plural हो Article का use नहीं होता है |\nExample:\nAdvice, Cattle.",
                        "9. उन noun के पहले जो compliments हों |\nExample:\nThey made him emperor.",
                        "10. जब two और more adjective एक ही noun को Qualify करें और वे ‘And’ से जुड़े हों तो Article पहले वाले adjective के पूर्व ही आता है |\nExample:\nThe red and white flower.\n(The red and the white flower. - Wrong)",
                        "11. जब दो या दो से अधिक adjective different nouns को qualify करें तो Article प्रत्येक adjective के पहले होता है |\nExample:\nThe red and the white flower.\n(इसका मतलब है कि दो फूल हैं, एक लाल और दूसरा सफेद |)",
                        "Note for rule 11:\nयदि noun plural मे है तो article को repeat की आवश्यकता नहीं है |\nExample:\nThe First And Second Chapters.",
                        "12. जब two और more Nouns different people और things से संबंध रखते हों तो Article प्रत्येक के पूर्व (before every one) आता है |\nExample:\nThe manager and the president have come.\n(यहाँ दोनों पदों पर अलग-अलग व्यक्ति हैं |)"
                    )
                    additionalRules.forEachIndexed { index, text -> ColoredPoint(text, index + 1) }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    GrammarTheme {
        ArticleContent()
    }
}
