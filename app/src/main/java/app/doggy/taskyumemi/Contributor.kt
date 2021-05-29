package app.doggy.taskyumemi

import com.google.gson.annotations.SerializedName

data class Contributor (
    val login: String,
    @SerializedName("avatar_url") val imageUrl: String,
    val followers: Int,
    val following: Int,
    val name: String
)