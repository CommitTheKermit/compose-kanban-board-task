package woowacourse.kanban.board.model

class KanbanCardData(val headerText: String, val content: String, val tagList: List<String> = listOf(), val accountName: String) {
    init {
        require(
            headerText.isNotEmpty() && headerText.trim().isNotEmpty(),
        ) { TITLE_ERROR }
        require(
            accountName.isNotEmpty() && accountName.trim().isNotEmpty(),
        ) { ACCOUNT_ERROR }
    }

    val displayTags: List<String> =
        tagList
            .take(5)
            .map {
                if (it.length > 5) it.substring(0, 5) else it
            }

    val hasContent: Boolean = content.isNotEmpty()
}
