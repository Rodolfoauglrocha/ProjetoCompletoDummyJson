package rodolfo.projects.projetoCompletoDummyJson.data.remote

import retrofit2.http.GET
import rodolfo.projects.projetoCompletoDummyJson.data.model.CartResponse
import rodolfo.projects.projetoCompletoDummyJson.data.model.PostResponse
import rodolfo.projects.projetoCompletoDummyJson.data.model.ProductResponse
import rodolfo.projects.projetoCompletoDummyJson.data.model.UserResponse

interface DummyJsonAPI {
    @GET("carts")
    suspend fun getCarts() : CartResponse

    @GET("users")
    suspend fun getUsers(): UserResponse

    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("posts")
    suspend fun getPosts(): PostResponse
}