package rodolfo.projects.projetoCompletoDummyJson.repository

import rodolfo.projects.projetoCompletoDummyJson.data.model.User
import rodolfo.projects.projetoCompletoDummyJson.data.remote.DummyJsonAPI
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: DummyJsonAPI
) : UserRepository {
    override suspend fun getUsers() : List<User>{
        return api.getUsers().users
    }
}