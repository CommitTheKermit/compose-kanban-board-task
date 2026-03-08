package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomChip(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                color = Color(0xfff3f4f6),
                shape = RoundedCornerShape(16.dp),
            )
            .padding(
                vertical = 5.dp,
                horizontal = 8.dp,
            )
            .testTag("tag"),
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
        )
    }
}
