package rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rodolfo.projects.projetoCompletoDummyJson.data.model.Post
import rodolfo.projects.projetoCompletoDummyJson.repository.PostRepository
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel(){

    private val _posts = MutableLiveData<List<Post>>()
    val posts : LiveData<List<Post>> = _posts

    fun getPosts(){
        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }
}