package rodolfo.projects.projetoCompletoDummyJson.data.model

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: Reactions,
    val views: Int,
    val userId: Int
)