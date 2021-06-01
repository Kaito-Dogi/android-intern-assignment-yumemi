package app.doggy.taskyumemi

import com.google.gson.annotations.SerializedName

data class Repository(
    val name: String,
    @SerializedName("updated_at") val updatedAt: String,
    val language: String
)