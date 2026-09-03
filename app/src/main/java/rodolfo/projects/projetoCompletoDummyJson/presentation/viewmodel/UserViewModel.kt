package rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rodolfo.projects.projetoCompletoDummyJson.data.model.User
import rodolfo.projects.projetoCompletoDummyJson.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel(){

    private val _users = MutableLiveData<List<User>>()
    val users : LiveData<List<User>> = _users

    fun getUsers(){
        viewModelScope.launch {
            _users.value = repository.getUsers()
        }
    }
}