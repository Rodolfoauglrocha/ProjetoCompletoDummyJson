package rodolfo.projects.projetoCompletoDummyJson.repository

import rodolfo.projects.projetoCompletoDummyJson.data.model.Product

interface ProductRepository {

    suspend fun getProducts() : List<Product>
}