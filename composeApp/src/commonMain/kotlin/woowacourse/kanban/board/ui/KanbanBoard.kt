package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.model.KanbanCardData

@Composable
fun KanbanBoardCard(
    headerText: String,
    content: String,
    tagList: List<String> = listOf(),
    accountName: String,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .width(286.dp)
            .clip(
                shape = RoundedCornerShape(16.dp),
            )
            .background(
                color = Color(0xffffffff),
            )
            .border(
                color = Color(0xffE5E7Eb),
                width = 1.dp,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(all = 17.dp),
    ) {
        Text(
            text = headerText,
            fontSize = 16.sp,
            letterSpacing = 0.3.sp,
            lineHeight = 24.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
        )
        if (content.isNotEmpty())
            Text(
                text = content,
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
            tagList.forEachIndexed { index, it ->
                if (index < 5)
                    CustomChip(
                        text = if (it.length > 5) it.substring(
                            0,
                            5,
                        ) else it,
                    )
            }
        }
        HorizontalDivider()
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "프로필기본값",
                modifier = Modifier.size(24.dp),
                tint = Color(0xff838383),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = accountName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

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
            ),
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
        )
    }
}

internal class KanbanBoardPreviewProvider : PreviewParameterProvider<KanbanCardData> {
    override val values = sequenceOf(
        KanbanCardData(
            headerText = "Lazy Column 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagList = listOf(
                "컴포넌트",
                "성능",
            ),
            accountName = "다이노",
        ),
        KanbanCardData(
            headerText = "Lazy Column 컴포넌트 구현",
            content = "",
            tagList = listOf(
                "컴포넌트",
                "성능",
            ),
            accountName = "다이노",
        ),
        KanbanCardData(
            headerText = "Lazy Column 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagList = listOf(),
            accountName = "다이노",
        ),
        KanbanCardData(
            headerText = "Lazy Column 컴포넌트 구현",
            content = "",
            tagList = listOf(),
            accountName = "다이노",
        ),
        KanbanCardData(
            headerText = "너무너무 긴 제목은 한 줄까지만 노출너무너무 긴 제목은 한 줄까지만 노출",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노",
            tagList = listOf(
                "너무너무",
                "긴 태그",
                "최대로",
                "5자까지진짜로",
                "5개제한임",
                "6개",
            ),
            accountName = "너무너무너무 긴 담당자도 한 줄너무너무너무 긴 담당자도 한 줄",
        ),
    )
}

@Composable
@Preview
fun KanbanCardPreview(@PreviewParameter(KanbanBoardPreviewProvider::class) data: KanbanCardData) {
    KanbanBoardCard(
        headerText = data.headerText,
        content = data.content,
        tagList = data.tagList,
        accountName = data.accountName,
    )
}
