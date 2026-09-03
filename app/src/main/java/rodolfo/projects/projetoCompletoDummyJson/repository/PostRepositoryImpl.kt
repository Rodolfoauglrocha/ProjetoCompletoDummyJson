package rodolfo.projects.projetoCompletoDummyJson.repository

import android.view.View
import androidx.lifecycle.ViewModel
import rodolfo.projects.projetoCompletoDummyJson.data.model.Post
import rodolfo.projects.projetoCompletoDummyJson.data.remote.DummyJsonAPI
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: DummyJsonAPI
) : PostRepository{
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().posts
    }
}