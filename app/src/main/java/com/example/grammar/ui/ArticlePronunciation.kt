package com.example.grammar.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grammar.R
import com.example.grammar.ui.theme.GrammarTheme
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ArticlePronunciation(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.Transparent,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            // THE Header
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "THE",
                    fontSize = 30.sp,
                    color = Color(0xFFF44336),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayLarge,
                )
                Text(
                    text = "THE",
                    fontSize = 30.sp,
                   color = Color(0xFF444444),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayLarge.copy(
                        drawStyle = Stroke(width = 1f, cap = StrokeCap.Round),
                    ),
                )
            }

            // Arrows and Labels
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                ArrowsCanvas(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    LabelText(
                        text = stringResource(R.string.english_label),
                        modifier = Modifier.weight(1f),
                    )
                    LabelText(
                        text = stringResource(R.string.hindi_label),
                        modifier = Modifier.weight(1f),
                    )
                    LabelText(
                        text = stringResource(R.string.arabic_label),
                        modifier = Modifier.weight(1f),
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            // Correct Pronunciation Title
            Text(
                text = stringResource(R.string.pronunciation_title),
                color = Color(0xFF2E7D32), // Darker Green
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Vowels Section
            PronunciationSection(
                prefix = "The",
                suffix = " + Vowels = दी",
                examples = listOf(
                    stringResource(R.string.example_ant),
                    stringResource(R.string.example_elephant),
                    stringResource(R.string.example_apple),
                    stringResource(R.string.example_orange),
                ),
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Consonants Section
            PronunciationSection(
                prefix = "The",
                suffix = " + Consonants = द",
                examples = listOf(
                    stringResource(R.string.example_rock),
                    stringResource(R.string.example_car),
                    stringResource(R.string.example_guide),
                    stringResource(R.string.example_message),
                ),
            )
        }
    }
}

@Composable
private fun LabelText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = Color(0xFFD32F2F), // Brighter Red
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        lineHeight = 22.sp,
        modifier = modifier,
    )
}

@Composable
private fun PronunciationSection(prefix: String, suffix: String, examples: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFF555555))) {
                    append(prefix)
                }
                withStyle(SpanStyle(color = Color(0xFFD32F2F))) {
                    append(suffix)
                }
            },
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Column(
            modifier = Modifier.padding(start = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            examples.forEach { example ->
                Text(
                    text = example,
                    fontSize = 20.sp,
                    color = Color(0xFF666666), // Muted gray
                )
            }
        }
    }
}

@Composable
private fun ArrowsCanvas(modifier: Modifier = Modifier, color: Color) {
    Canvas(modifier = modifier) {
        val centerX = size.width / 2
        val startY = 0f
        val endY = size.height - 10f
        val widthOffset = size.width / 3.5f

        // Middle Arrow
        drawArrow(
            start = Offset(centerX, startY),
            end = Offset(centerX, endY),
            color = color,
        )

        // Left Arrow
        drawArrow(
            start = Offset(centerX - 20f, startY),
            end = Offset(centerX - widthOffset, endY),
            color = color,
        )

        // Right Arrow
        drawArrow(
            start = Offset(centerX + 20f, startY),
            end = Offset(centerX + widthOffset, endY),
            color = color,
        )
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawArrow(
    start: Offset,
    end: Offset,
    color: Color,
) {
    val strokeWidth = 1.5.dp.toPx()
    drawLine(
        color = color,
        start = start,
        end = end,
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round,
    )

    // Arrow head
    val angle = atan2((end.y - start.y), (end.x - start.x))
    val arrowHeadLength = 20f
    val arrowHeadAngle = Math.PI / 8

    val path = Path().apply {
        moveTo(end.x, end.y)
        lineTo(
            (end.x - (arrowHeadLength * cos(angle - arrowHeadAngle))).toFloat(),
            (end.y - (arrowHeadLength * sin(angle - arrowHeadAngle))).toFloat(),
        )
        moveTo(end.x, end.y)
        lineTo(
            (end.x - (arrowHeadLength * cos(angle + arrowHeadAngle))).toFloat(),
            (end.y - (arrowHeadLength * sin(angle + arrowHeadAngle))).toFloat(),
        )
    }
    drawPath(
        path = path,
        color = color,
        style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
    )
}

@Preview(showBackground = true)
@Composable
fun ArticlePronunciationPreview() {
    GrammarTheme {
        ArticlePronunciation()
    }
}
