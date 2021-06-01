package app.doggy.taskyumemi

import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoryService {

    //ContributorのRepositoryを取得する
    @GET("users/{login}/repos")
    suspend fun getRepositories(@Path("login") login: String): List<Repository>

}