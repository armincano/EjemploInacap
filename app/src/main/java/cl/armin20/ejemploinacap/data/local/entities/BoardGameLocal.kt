package cl.armin20.ejemploinacap.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.armin20.ejemploinacap.data.model.Classification

@Entity(tableName = "board_table")
data class BoardGameLocal(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val price: String,
    val players: String,
    val age: String,
    val year: Int,
    val playingTime: String,
    val description: String,
    val officialLink: String,
    val designer: String,
    val artist: String,
    val publisher: String,
    @Embedded
    val classification: Classification
)
