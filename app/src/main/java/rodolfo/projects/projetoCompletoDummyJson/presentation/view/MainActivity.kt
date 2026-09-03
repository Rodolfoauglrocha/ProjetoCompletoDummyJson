package rodolfo.projects.projetoCompletoDummyJson.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import rodolfo.projects.projetoCompletoDummyJson.databinding.ActivityMainBinding
import rodolfo.projects.projetoCompletoDummyJson.presentation.adapter.CartAdapter
import rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel.CartViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: CartViewModel by viewModels()
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.cardCarts.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        binding.cardUsers.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }

        binding.cardProducts.setOnClickListener {
            startActivity(Intent(this, ProductActivity::class.java))
        }

        binding.cardPosts.setOnClickListener {
            startActivity(Intent(this, PostActivity::class.java))
        }
    }
}