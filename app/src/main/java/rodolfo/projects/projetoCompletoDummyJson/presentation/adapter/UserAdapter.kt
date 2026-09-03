package rodolfo.projects.projetoCompletoDummyJson.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rodolfo.projects.projetoCompletoDummyJson.data.model.User
import rodolfo.projects.projetoCompletoDummyJson.databinding.ItemUserBinding

class UserAdapter(
    private var users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.tvName.text = "${user.firstName} ${user.lastName}"
            binding.tvUsername.text = user.username
            binding.tvEmail.text = user.email
            binding.tvPhone.text = user.phone
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {

        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun updateList(newList: List<User>) {
        users = newList
        notifyDataSetChanged()
    }
}