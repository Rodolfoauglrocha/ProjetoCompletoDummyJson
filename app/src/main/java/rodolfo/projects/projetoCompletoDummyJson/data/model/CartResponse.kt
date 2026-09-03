package rodolfo.projects.projetoCompletoDummyJson.data.model

data class CartResponse(
    val carts: List<Cart>,
    val total: Int,
    val skip: Int,
    val limit: Int
)