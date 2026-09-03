package rodolfo.projects.projetoCompletoDummyJson.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rodolfo.projects.projetoCompletoDummyJson.data.model.Post
import rodolfo.projects.projetoCompletoDummyJson.databinding.ItemPostBinding

class PostAdapter(
    private var posts: List<Post>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(
        private val binding: ItemPostBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.tvPostTitle.text = post.title
            binding.tvPostBody.text = post.body
            binding.tvPostViews.text = "Visualizações: ${post.views}"
            binding.tvPostReactions.text =
                "👍 ${post.reactions.likes}   👎 ${post.reactions.dislikes}"
            binding.tvPostTags.text = post.tags.joinToString(" • ")
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {

        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    fun updateList(newList: List<Post>) {
        posts = newList
        notifyDataSetChanged()
    }
}