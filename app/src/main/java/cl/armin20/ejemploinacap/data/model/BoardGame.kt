package cl.armin20.ejemploinacap.data.model

import com.google.gson.annotations.SerializedName

data class BoardGame(
    val id: Int,
    val name: String,
    val image: String,
    val price: String,
    val players: String,
    val age: String,
    val year: Int,
    @SerializedName("playing_time")
    val playingTime: String,
    val description: String,
    @SerializedName("official_link")
    val officialLink: String,
    @SerializedName("Designer")
    val designer: String,
    @SerializedName("Artist")
    val artist: String,
    @SerializedName("Publisher")
    val publisher: String,
    val classification:Classification
)

data class Classification(
    val category: String,
    val mechanisms: String
)
