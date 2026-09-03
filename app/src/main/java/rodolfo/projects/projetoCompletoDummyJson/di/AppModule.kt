package rodolfo.projects.projetoCompletoDummyJson.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rodolfo.projects.projetoCompletoDummyJson.data.remote.DummyJsonAPI
import rodolfo.projects.projetoCompletoDummyJson.repository.CartRepository
import rodolfo.projects.projetoCompletoDummyJson.repository.CartRepositoryImpl
import rodolfo.projects.projetoCompletoDummyJson.repository.PostRepository
import rodolfo.projects.projetoCompletoDummyJson.repository.PostRepositoryImpl
import rodolfo.projects.projetoCompletoDummyJson.repository.ProductRepository
import rodolfo.projects.projetoCompletoDummyJson.repository.ProductRepositoryImpl
import rodolfo.projects.projetoCompletoDummyJson.repository.UserRepository
import rodolfo.projects.projetoCompletoDummyJson.repository.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideCartAPI(retrofit: Retrofit): DummyJsonAPI {
        return retrofit.create(DummyJsonAPI::class.java)
    }

    @Provides
    fun provideCartRepository(
        api: DummyJsonAPI
    ): CartRepository {
        return CartRepositoryImpl(api)
    }

    @Provides
    fun provideUserRepository(
        api: DummyJsonAPI
    ) : UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    fun provideProductsRepository(
        api: DummyJsonAPI
    ) : ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    fun providePostsRepository(
        api: DummyJsonAPI
    ) : PostRepository {
        return PostRepositoryImpl(api)
    }
}