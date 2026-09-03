package rodolfo.projects.projetoCompletoDummyJson.repository

import rodolfo.projects.projetoCompletoDummyJson.data.model.User

interface UserRepository {
    suspend fun getUsers() : List<User>
}