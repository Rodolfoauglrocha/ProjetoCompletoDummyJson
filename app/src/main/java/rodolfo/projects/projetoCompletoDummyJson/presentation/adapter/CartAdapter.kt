package rodolfo.projects.projetoCompletoDummyJson.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rodolfo.projects.projetoCompletoDummyJson.data.model.Cart
import rodolfo.projects.projetoCompletoDummyJson.databinding.ItemCartBinding

class CartAdapter(
    private var carts: List<Cart>,
    private val onCLick: (Cart) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {
        holder.bind(carts[position])
    }

    override fun getItemCount(): Int {
        return carts.size
    }

    fun updateList(newList: List<Cart>) {
        carts = newList
        notifyDataSetChanged()
    }

    inner class CartViewHolder(
        private val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cart: Cart) {
            binding.tvCartId.text = "Carrinho: ${cart.id}"
            binding.tvUserId.text = "Usuário: ${cart.userId}"
            binding.tvTotal.text = "Total: R$ ${cart.total}"
            binding.tvProducts.text = "Produtos: ${cart.totalProducts}"

            binding.root.setOnClickListener {
                onCLick(cart)
            }
        }
    }
}