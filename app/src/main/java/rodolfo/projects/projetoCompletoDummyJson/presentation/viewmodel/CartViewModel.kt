package rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rodolfo.projects.projetoCompletoDummyJson.data.model.Cart
import rodolfo.projects.projetoCompletoDummyJson.repository.CartRepository
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository
) : ViewModel(){

    private val _carts = MutableLiveData<List<Cart>>()
    val carts : LiveData<List<Cart>> = _carts

    fun getCarts(){
        viewModelScope.launch {
            _carts.value = repository.getCarts()
        }
    }
}