package woowacourse.kanban.board.model

class KanbanCardData(val headerText: String, val content: String, val tagList: List<String> = listOf(), val accountName: String) {
    init {
        require(
            headerText.isNotEmpty() && headerText.trim().isNotEmpty(),
        ) { "제목은 비거나 공백일 수 없습니다." }
        require(
            accountName.isNotEmpty() && accountName.trim().isNotEmpty(),
        ) { "담당자 이름은 비거나 공백일 수 없습니다." }
    }

    val displayTags: List<String> =
        tagList
            .take(5)
            .map {
                if (it.length > 5) it.substring(0, 5) else it
            }

    val hasContent: Boolean = content.isNotEmpty()
}
