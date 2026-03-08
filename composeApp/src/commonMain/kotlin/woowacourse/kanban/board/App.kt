package woowacourse.kanban.board

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.model.KanbanCardData
import woowacourse.kanban.board.ui.KanbanBoardCard

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column {
            KanbanBoardCard(
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
    }
}
