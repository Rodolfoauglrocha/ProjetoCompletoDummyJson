package rodolfo.projects.projetoCompletoDummyJson.repository

import rodolfo.projects.projetoCompletoDummyJson.data.model.Product
import rodolfo.projects.projetoCompletoDummyJson.data.remote.DummyJsonAPI
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api : DummyJsonAPI
) : ProductRepository{
    override suspend fun getProducts(): List<Product> {
        return api.getProducts().products
    }
}