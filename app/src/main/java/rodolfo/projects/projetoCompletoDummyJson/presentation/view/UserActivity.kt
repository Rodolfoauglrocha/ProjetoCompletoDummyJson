package rodolfo.projects.projetoCompletoDummyJson.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import rodolfo.projects.projetoCompletoDummyJson.databinding.ActivityUserBinding
import rodolfo.projects.projetoCompletoDummyJson.presentation.adapter.UserAdapter
import rodolfo.projects.projetoCompletoDummyJson.presentation.viewmodel.UserViewModel

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private val viewModel: UserViewModel by viewModels()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter(emptyList())

        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter

        binding.fabVoltar.setOnClickListener {
            finish()
        }

        viewModel.users.observe(this) { users ->
            adapter.updateList(users)
        }

        viewModel.getUsers()
    }
}