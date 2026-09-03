package rodolfo.projects.projetoCompletoDummyJson.data.model

data class PostResponse(
    val posts: List<Post>,
    val total: Int,
    val skip: Int,
    val limit: Int
)