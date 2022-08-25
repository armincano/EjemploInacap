package cl.armin20.ejemploinacap.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.armin20.ejemploinacap.data.local.BoardDao
import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal
import cl.armin20.ejemploinacap.data.remote.ApiRetrofit

class BoardGameRepository(private val boardDao: BoardDao) {

    private val retrofitService = ApiRetrofit.retrofitInstance()

    private val errorMessage = MutableLiveData<String>()

    fun getAllBoardFromDB(): LiveData<List<BoardGameLocal>> {
        return boardDao.getAllBoardGames()
    }

    fun getBoardGameById(id: Int): LiveData<BoardGameLocal> {
        return boardDao.getBoardGame(id)
    }

    suspend fun fetchAllBoardGames() {
        val response = retrofitService.getBoardGamesData()
        when(response.isSuccessful) {
            true -> {
                if (response.body().isNullOrEmpty()) {
                    errorMessage.value = "ERROR IS NULL OR EMPTY"
                } else {
                    Log.d("CRISS", "${response.body()}")
                    boardDao.insertAllBoardGames(fromRemoteToLocalEntity(response.body()!!))
                }
            }
            false -> {
                Log.e("${response.code()}", "NOT SUCCESSFULLY ${response.errorBody()}")
                errorMessage.value = response.message()
            }
        }
    }

}