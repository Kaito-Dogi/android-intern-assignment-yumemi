package app.doggy.taskyumemi

data class Contributor (
    val login: String,
    val imageUrl: String,
    val followers: Int,
    val following: Int,
    val name: String
)