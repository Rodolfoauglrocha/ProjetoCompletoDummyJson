package rodolfo.projects.projetoCompletoDummyJson.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import rodolfo.projects.projetoCompletoDummyJson.databinding.ActivityProductBinding
import rodolfo.projects.projetoCompletoDummyJson.presentation.adapter.ProductAdapter
import rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel.ProductViewModel
import kotlin.getValue

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val viewModel: ProductViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductAdapter(emptyList())

        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = adapter

        viewModel.products.observe(this) { products ->
            adapter.updateList(products)
        }

        viewModel.getProducts()
    }
}