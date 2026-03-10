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
            .take(Config.MAX_TAG_COUNT)
            .map {
                if (it.length > Config.MAX_TAG_CONTENT_SIZE) it.substring(0, Config.MAX_TAG_CONTENT_SIZE) else it
            }

    val hasContent: Boolean = content.isNotEmpty()
}
