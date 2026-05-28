package com.example.grammar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Color palette for alternating point backgrounds
val PointColors = listOf(
    Color(0xFFE3F2FD), // Light Blue
    Color(0xFFF1F8E9), // Light Green
    Color(0xFFFFF3E0), // Light Orange
    Color(0xFFF3E5F5), // Light Purple
    Color(0xFFE0F7FA), // Light Cyan
    Color(0xFFFFF9C4)  // Light Yellow
)

@Composable
fun BulletPoint(text: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)) {
        Box(modifier = Modifier.size(6.dp).background(color, shape = CircleShape))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 15.sp, color = Color.DarkGray)
    }
}

/**
 * A stylized point with a colored background to differentiate multiple items in a section.
 */
@Composable
fun ColoredPoint(text: String, index: Int) {
    val bgColor = PointColors[index % PointColors.size]
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        color = bgColor,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .size(6.dp)
                    .background(Color.DarkGray, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                fontSize = 15.sp,
                color = Color.Black,
                lineHeight = 20.sp
            )
        }
    }
}

@Composable
fun ContentSection(title: String, titleColor: Color, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = titleColor, modifier = Modifier.padding(bottom = 12.dp))
            content()
        }
    }
}

@Composable
fun ExampleItem(label: String, example: String) {
    Column(modifier = Modifier.padding(start = 12.dp, top = 4.dp, bottom = 8.dp)) {
        Text(text = label, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color.Gray)
        Text(text = example, fontStyle = FontStyle.Italic, fontSize = 15.sp, color = Color.Black)
    }
}

@Composable
fun RuleBox(text: String) {
    Surface(
        color = Color(0xFFFFF3E0),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, modifier = Modifier.padding(12.dp), fontSize = 14.sp, color = Color(0xFFBF360C), fontWeight = FontWeight.Medium)
    }
}

@Composable
fun SubSectionTitle(text: String, color: Color) {
    Text(text = text, fontSize = 17.sp, fontWeight = FontWeight.Bold, color = color, modifier = Modifier.padding(bottom = 8.dp, top = 4.dp))
}

@Composable
fun RowScope.TableCellText(text: String, weight: Float, isHeader: Boolean = false) {
    Box(
        modifier = Modifier.weight(weight).border(0.5.dp, Color(0xFFCFD8DC)).padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal,
            color = if (isHeader) Color.White else Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RowScope.VoiceTableCell(
    text: String,
    weight: Float,
    isHeader: Boolean = false,
    borderColor: Color = Color.Transparent,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Box(
        modifier = Modifier
            .weight(weight)
            .fillMaxHeight()
            .border(0.5.dp, borderColor)
            .padding(8.dp),
        contentAlignment = if (isHeader) Alignment.Center else Alignment.TopStart
    ) {
        Text(
            text = text,
            fontSize = if (isHeader) 14.sp else 12.sp,
            textAlign = if (isHeader) TextAlign.Center else TextAlign.Start,
            color = if (isHeader) Color.White else Color.Black,
            fontWeight = fontWeight,
            lineHeight = 16.sp
        )
    }
}

@Composable
fun TenseTableLayout() {
    val borderColor = Color(0xFF673AB7)
    val headerColor = Color(0xFF3F51B5)
    val rowHeaderColor = Color(0xFF3F51B5)

    Column(modifier = Modifier.fillMaxWidth().border(1.dp, borderColor)) {
        // Table Headers
        Row(modifier = Modifier.height(IntrinsicSize.Max).background(headerColor)) {
            TableCellView("Tense Type", Color.White, FontWeight.Bold, isHeader = true, weight = 0.8f)
            TableCellView("Simple", Color.White, FontWeight.Bold, isHeader = true, weight = 1f)
            TableCellView("Continuous", Color.White, FontWeight.Bold, isHeader = true, weight = 1f)
            TableCellView("Perfect", Color.White, FontWeight.Bold, isHeader = true, weight = 1f)
            TableCellView("Perf. Cont.", Color.White, FontWeight.Bold, isHeader = true, weight = 1f)
        }

        // Row: Present
        TenseRowData(
            title = "Present",
            cells = listOf(
                "+ V1 (s/es)\n- do/does not + V1\n? Do/Does_ + V1",
                "+ am/is/are + Ving\n- am/is/are not + Ving",
                "+ have/has + V3\n- have/has not + V3",
                "+ have/has been + Ving\n- have/has not been + Ving"
            ),
            rowHeaderColor = rowHeaderColor
        )

        // Row: Past
        TenseRowData(
            title = "Past",
            cells = listOf(
                "+ V2\n- did not + V1\n? Did_ + V1",
                "+ was/were + Ving\n- was/were not + Ving",
                "+ had + V3\n- had not + V3",
                "+ had been + Ving\n- had not been + Ving"
            ),
            rowHeaderColor = rowHeaderColor
        )

        // Row: Future
        TenseRowData(
            title = "Future",
            cells = listOf(
                "+ will + V1\n- will not + V1\n? Will_ + V1",
                "+ will be + Ving\n- will not be + Ving",
                "+ will have + V3\n- will not have + V3",
                "+ will have been + Ving\n- will not have been + Ving"
            ),
            rowHeaderColor = rowHeaderColor
        )
    }
}

@Composable
fun TenseRowData(
    title: String,
    cells: List<String>,
    rowHeaderColor: Color
) {
    Row(modifier = Modifier.height(IntrinsicSize.Max)) {
        TableCellView(title, rowHeaderColor, FontWeight.Bold, weight = 0.8f)
        cells.forEach { cellContent ->
            TableCellView(cellContent, Color.Black, weight = 1f)
        }
    }
}

@Composable
fun RowScope.TableCellView(
    text: String,
    color: Color,
    fontWeight: FontWeight = FontWeight.Normal,
    isHeader: Boolean = false,
    weight: Float = 1f
) {
    val borderColor = Color(0xFFCFD8DC)
    Box(
        modifier = Modifier
            .weight(weight)
            .fillMaxHeight()
            .border(0.5.dp, borderColor)
            .padding(4.dp),
        contentAlignment = if (isHeader) Alignment.Center else Alignment.TopStart
    ) {
        Text(
            text = text,
            color = color,
            fontWeight = fontWeight,
            fontSize = if (isHeader) 11.sp else 10.sp,
            textAlign = if (isHeader) TextAlign.Center else TextAlign.Start,
            lineHeight = 11.sp
        )
    }
}

@Composable
fun VoiceTable() {
    val borderColor = Color(0xFF7B1FA2)
    Column(modifier = Modifier.border(1.dp, borderColor)) {
        // Headers
        Row(modifier = Modifier.background(borderColor).fillMaxWidth().height(IntrinsicSize.Max)) {
            VoiceTableCell(text = "Tense", weight = 1f, isHeader = true)
            VoiceTableCell(text = "Indefinite", weight = 1.2f, isHeader = true)
            VoiceTableCell(text = "Cont.", weight = 1.3f, isHeader = true)
            VoiceTableCell(text = "Perfect", weight = 1.2f, isHeader = true)
            VoiceTableCell(text = "Perf. Cont.", weight = 1.2f, isHeader = true)
        }

        VoiceTableRow("Present", "am, is, are", "am being, is being, are being", "have been, has been", "X", borderColor)
        VoiceTableRow("Past", "was, were", "was being, were being", "had been", "X", borderColor)
        VoiceTableRow("Future", "will be, shall be", "X", "will have been, shall have been", "X", borderColor)
    }
}

@Composable
fun VoiceTableRow(tense: String, indef: String, cont: String, perf: String, perfCont: String, borderColor: Color) {
    Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {
        VoiceTableCell(text = tense, weight = 1f, borderColor = borderColor, fontWeight = FontWeight.Bold)
        VoiceTableCell(text = indef, weight = 1.2f, borderColor = borderColor)
        VoiceTableCell(text = cont, weight = 1.3f, borderColor = borderColor)
        VoiceTableCell(text = perf, weight = 1.2f, borderColor = borderColor)
        VoiceTableCell(text = perfCont, weight = 1.2f, borderColor = borderColor)
    }
}

@Composable
fun PrepositionRule(title: String, active: String, passive: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(title, fontWeight = FontWeight.Bold, color = Color(0xFF5D4037), fontSize = 14.sp)
        Text("A: $active", fontSize = 14.sp, fontStyle = FontStyle.Italic, color = Color.Black)
        Text("P: $passive", fontSize = 14.sp, fontStyle = FontStyle.Italic, color = Color(0xFF1B5E20))
    }
}

@Composable
fun PronounTableLayout() {
    val borderColor = Color(0xFFC62828)
    Column(modifier = Modifier.border(1.dp, borderColor)) {
        Row(modifier = Modifier.background(borderColor).fillMaxWidth().height(IntrinsicSize.Max)) {
            VoiceTableCell(text = "Person", weight = 1f, isHeader = true)
            VoiceTableCell(text = "Subject", weight = 1f, isHeader = true)
            VoiceTableCell(text = "Object", weight = 1f, isHeader = true)
            VoiceTableCell(text = "Possessive", weight = 1.5f, isHeader = true)
        }
        
        PronounRowItem("First", "I, we", "Me, Us", "My, Mine, our, ours", borderColor)
        PronounRowItem("Second", "You", "You", "your, yours", borderColor)
        PronounRowItem("Third", "He, She, It, They", "Him, Her, It, Them", "His, Her, Hers, It, Their, Theirs", borderColor)
    }
}

@Composable
fun PronounRowItem(person: String, subj: String, obj: String, poss: String, borderColor: Color) {
    Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {
        VoiceTableCell(text = person, weight = 1f, borderColor = borderColor, fontWeight = FontWeight.Bold)
        VoiceTableCell(text = subj, weight = 1f, borderColor = borderColor)
        VoiceTableCell(text = obj, weight = 1f, borderColor = borderColor)
        VoiceTableCell(text = poss, weight = 1.5f, borderColor = borderColor)
    }
}
