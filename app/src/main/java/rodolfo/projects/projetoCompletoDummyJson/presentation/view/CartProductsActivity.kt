package rodolfo.projects.projetoCompletoDummyJson.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import rodolfo.projects.projetoCompletoDummyJson.data.model.Cart
import rodolfo.projects.projetoCompletoDummyJson.databinding.ActivityCartProductsBinding
import rodolfo.projects.projetoCompletoDummyJson.presentation.adapter.CartProductAdapter

class CartProductsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCartProductsBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: CartProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val cart = intent.getParcelableExtra<Cart>("CART")
        binding.fabVoltar.setOnClickListener {
            finish()
        }

        if (cart != null) {

            adapter = CartProductAdapter(cart.products)

            binding.rvCartProducts.layoutManager =
                LinearLayoutManager(this)

            binding.rvCartProducts.adapter = adapter
        }
    }
}