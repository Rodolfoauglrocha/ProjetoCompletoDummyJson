package rodolfo.projects.projetoCompletoDummyJson.repository

import rodolfo.projects.projetoCompletoDummyJson.data.model.Cart
import rodolfo.projects.projetoCompletoDummyJson.data.remote.DummyJsonAPI
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val api: DummyJsonAPI
) : CartRepository{
    override suspend fun getCarts() : List<Cart>{
        return api.getCarts().carts
    }
}