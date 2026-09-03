package rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rodolfo.projects.projetoCompletoDummyJson.data.model.Product
import rodolfo.projects.projetoCompletoDummyJson.repository.ProductRepository
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel(){

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>> = _products

    fun getProducts(){
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }
}