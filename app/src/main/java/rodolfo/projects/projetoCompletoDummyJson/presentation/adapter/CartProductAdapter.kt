package rodolfo.projects.projetoCompletoDummyJson.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rodolfo.projects.projetoCompletoDummyJson.data.model.CartProduct
import rodolfo.projects.projetoCompletoDummyJson.databinding.ItemCartProductBinding

class CartProductAdapter(
    private var products: List<CartProduct>
) : RecyclerView.Adapter<CartProductAdapter.CartProductViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartProductViewHolder {

        val binding = ItemCartProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CartProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CartProductViewHolder,
        position: Int
    ) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class CartProductViewHolder(
        private val binding: ItemCartProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: CartProduct) {

            binding.tvProductTitle.text = product.title
            binding.tvProductPrice.text = "Preço: R$ ${product.price}"
            binding.tvProductQuantity.text = "Quantidade: ${product.quantity}"
            binding.tvProductTotal.text = "Total: R$ ${product.total}"
        }
    }
}