package rodolfo.projects.projetoCompletoDummyJson.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rodolfo.projects.projetoCompletoDummyJson.data.model.Product
import rodolfo.projects.projetoCompletoDummyJson.databinding.ItemProductBinding

class ProductAdapter(
    private var products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.tvProductName.text = product.title
            binding.tvProductPrice.text = "Preço: R$ ${product.price}"
            binding.tvProductCategory.text = "Categoria: ${product.category}"
            binding.tvProductRating.text = "Avaliação: ${product.rating}"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    fun updateList(newList: List<Product>) {
        products = newList
        notifyDataSetChanged()
    }
}