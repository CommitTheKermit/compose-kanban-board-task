package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertEquals
import woowacourse.kanban.board.model.KanbanCardData

class TagTest {

    @Test
    fun `태그가 5개 초과하면 5개까지만 표시`() {
        val data =
            KanbanCardData(
                headerText = "제목",
                content = "설명",
                tagList = listOf(
                    "태그1",
                    "태그2",
                    "태그3",
                    "태그4",
                    "태그5",
                    "태그6",
                ),
                accountName = "담당자명",
            )

        assertEquals(
            listOf(
                "태그1",
                "태그2",
                "태그3",
                "태그4",
                "태그5",
            ),
            data.displayTags,
        )
    }

    @Test
    fun `태그 텍스트가 5자 초과하면 5자까지만 표시`() {
        val data =
            KanbanCardData(
                headerText = "제목",
                content = "설명",
                tagList = listOf(
                    "012345",
                ),
                accountName = "담당자명",
            )

        assertEquals(
            listOf("01234"),
            data.displayTags,
        )
    }

    @Test
    fun `태그가 비어있으면 displayTags도 비어있음`() {
        val data =
            KanbanCardData(
                headerText = "제목",
                content = "설명",
                tagList = listOf(),
                accountName = "담당자명",
            )

        assertEquals(
            listOf(),
            data.displayTags,
        )
    }
}
