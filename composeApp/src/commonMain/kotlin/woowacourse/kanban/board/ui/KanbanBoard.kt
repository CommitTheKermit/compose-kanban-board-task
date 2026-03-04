package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun KanbanBoardCard() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .width(286.dp)
            .background(color = Color(0xffffffff), shape = RoundedCornerShape(16.dp))
            .border(color = Color(0xffE5E7Eb), width = 1.dp, shape = RoundedCornerShape(16.dp))
            .padding(all = 17.dp),
    ) {
        Text(
            text = "LazyColumn 컴포넌트 구현",
            fontSize = 16.sp,
            letterSpacing = 0.3.sp,
            lineHeight = 24.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = "새로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            fontSize = 14.sp,
            letterSpacing = 0.15.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.W400,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            CustomChip(text = "너무너무")
            CustomChip(text = "긴 태그")
            CustomChip(text = "최대로")
            CustomChip(text = "5자까지")
            CustomChip(text = "5개제한임")
        }
    }
}


@Composable
fun CustomChip(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = Color(0xfff3f4f6), shape = RoundedCornerShape(16.dp))
            .padding(vertical = 5.dp, horizontal = 8.dp),
    ) {
        Text(text = text, fontWeight = FontWeight.W400, fontSize = 12.sp)
    }
}