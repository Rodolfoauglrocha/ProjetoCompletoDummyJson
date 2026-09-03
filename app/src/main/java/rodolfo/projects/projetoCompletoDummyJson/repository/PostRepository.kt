package rodolfo.projects.projetoCompletoDummyJson.repository

import rodolfo.projects.projetoCompletoDummyJson.data.model.Post

interface PostRepository {
    suspend fun getPosts() : List<Post>
}