package app.doggy.taskyumemi

import retrofit2.http.GET

interface RepositoryService {

    //ContributorのRepositoryを取得する
    @GET("users/{login}/repos")
    suspend fun getRepositories(): List<Repository>

}