package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import woowacourse.kanban.board.model.KanbanCardData

class KanbanBoardDataTest {

    @Test
    fun `제목이 비어 있는 경우 생성 불가능`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanCardData(
                headerText = "",
                content = "너무너무너무 긴 설명",
                tagList = listOf(
                    "너무너무",
                ),
                accountName = "너무너무너무 긴 담당자도 한 줄",
            )
        }
        assertEquals("제목은 비거나 공백일 수 없습니다.", exception.message)
    }

    @Test
    fun `제목이 공백인 경우 생성 불가능`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanCardData(
                headerText = " ",
                content = "너무너무너무 긴 설명",
                tagList = listOf(
                    "너무너무",
                ),
                accountName = "너무너무너무 긴 담당자도 한 줄",
            )
        }
        assertEquals("제목은 비거나 공백일 수 없습니다.", exception.message)
    }

    @Test
    fun `담당자 이름이 비어 있는 경우 생성 불가능`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanCardData(
                headerText = "제목",
                content = "설명",
                tagList = listOf(
                    "태그",
                ),
                accountName = "",
            )
        }
        assertEquals("담당자 이름은 비거나 공백일 수 없습니다.", exception.message)
    }

    @Test
    fun `담당자 이름이 공백인 경우 생성 불가능`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            KanbanCardData(
                headerText = "제목",
                content = "설명",
                tagList = listOf(
                    "태그",
                ),
                accountName = " ",
            )
        }
        assertEquals("담당자 이름은 비거나 공백일 수 없습니다.", exception.message)
    }

    @Test
    fun `비어 있지 않고 공백도 아닌 데이터로 카드 생성`() {
        val data = KanbanCardData(
            headerText = "제목",
            content = "설명",
            tagList = listOf(
                "태그",
            ),
            accountName = "담당자명",
        )

        assertEquals("제목", data.headerText)
        assertEquals("설명", data.content)
        assertEquals(listOf("태그"), data.tagList)
        assertEquals("담당자명", data.accountName)
        assertEquals(listOf("태그"), data.displayTags)
        assertEquals(true, data.hasContent)
    }
}
