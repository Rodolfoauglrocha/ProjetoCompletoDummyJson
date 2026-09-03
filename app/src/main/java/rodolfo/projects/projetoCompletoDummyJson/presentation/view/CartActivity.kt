package rodolfo.projects.projetoCompletoDummyJson.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import rodolfo.projects.projetoCompletoDummyJson.databinding.ActivityCartBinding
import rodolfo.projects.projetoCompletoDummyJson.presentation.adapter.CartAdapter
import rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel.CartViewModel

@AndroidEntryPoint
class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private val viewModel: CartViewModel by viewModels()
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CartAdapter(emptyList()) { cart ->
            val intent = Intent(this, CartProductsActivity::class.java)
            intent.putExtra("CART", cart)
            startActivity(intent)

        }

        binding.rvCarts.layoutManager = LinearLayoutManager(this)
        binding.rvCarts.adapter = adapter

        binding.fabVoltar.setOnClickListener {
            finish()
        }

        viewModel.carts.observe(this) { carts ->
            adapter.updateList(carts)
        }

        viewModel.getCarts()
    }
}