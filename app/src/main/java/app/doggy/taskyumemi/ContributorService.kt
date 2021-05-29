package app.doggy.taskyumemi

import retrofit2.http.GET
import retrofit2.http.Path

interface ContributorService {

    //Contributorのloginを取得する
    @GET("repositories/90792131/contributors")
    suspend fun getContributorId(): String

    //取得したloginから，ユーザーの詳細な情報を取得する
    @GET("users/{login}")
    suspend fun getContributor(@Path("login") login: String): Contributor

}