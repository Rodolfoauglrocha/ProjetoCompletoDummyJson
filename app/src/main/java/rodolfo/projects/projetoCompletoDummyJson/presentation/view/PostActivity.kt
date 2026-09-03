package rodolfo.projects.projetoCompletoDummyJson.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import rodolfo.projects.projetoCompletoDummyJson.databinding.ActivityPostBinding
import rodolfo.projects.projetoCompletoDummyJson.presentation.adapter.PostAdapter
import rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel.PostViewModel

@AndroidEntryPoint
class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val viewModel: PostViewModel by viewModels()
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PostAdapter(emptyList())

        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.adapter = adapter

        binding.fabVoltar.setOnClickListener {
            finish()
        }

        viewModel.posts.observe(this) { posts ->
            adapter.updateList(posts)
        }

        viewModel.getPosts()
    }
}