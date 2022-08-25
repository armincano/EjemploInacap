package cl.armin20.ejemploinacap

import android.app.Application
import cl.armin20.ejemploinacap.data.BoardGameRepository
import cl.armin20.ejemploinacap.data.local.BoardGamesDataBase

class AppBoardGame: Application() {

    private val dataBase by lazy {BoardGamesDataBase.getDataBase(this)}
    val repository by lazy { BoardGameRepository(dataBase.getBoardGameDao()) }

}