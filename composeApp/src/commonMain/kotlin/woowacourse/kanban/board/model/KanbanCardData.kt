package woowacourse.kanban.board.model

data class KanbanCardData(val headerText: String, val content: String, val tagList: List<String> = listOf(), val accountName: String)
