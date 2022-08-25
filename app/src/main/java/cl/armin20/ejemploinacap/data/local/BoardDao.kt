package cl.armin20.ejemploinacap.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal

@Dao
interface BoardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBoardGames(listGames: List<BoardGameLocal>)

    @Query("SELECT * FROM board_table")
    fun getAllBoardGames(): LiveData<List<BoardGameLocal>>

    @Query("SELECT * FROM board_table WHERE id = :id")
    fun getBoardGame(id: Int): LiveData<BoardGameLocal>

}