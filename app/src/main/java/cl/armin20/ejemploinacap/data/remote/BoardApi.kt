package cl.armin20.ejemploinacap.data.remote

import androidx.lifecycle.LiveData
import cl.armin20.ejemploinacap.data.model.BoardGame
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BoardApi {
    @GET("board_games/")
    suspend fun getBoardGamesData(): Response<List<BoardGame>>

    @GET("board_games/{id}/")
    suspend fun getBoardGame(@Path("id") id:Int): Response<BoardGame>
}