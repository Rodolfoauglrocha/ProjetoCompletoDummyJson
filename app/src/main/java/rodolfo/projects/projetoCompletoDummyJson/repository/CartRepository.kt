package rodolfo.projects.projetoCompletoDummyJson.repository

import rodolfo.projects.projetoCompletoDummyJson.data.model.Cart

interface CartRepository {
    suspend fun getCarts() : List<Cart>
}