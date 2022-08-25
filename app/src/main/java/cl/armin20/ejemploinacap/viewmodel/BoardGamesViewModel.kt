package cl.armin20.ejemploinacap.viewmodel

import androidx.lifecycle.*
import cl.armin20.ejemploinacap.data.BoardGameRepository
import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal
import kotlinx.coroutines.launch

class BoardGamesViewModel(private val repository: BoardGameRepository): ViewModel() {


    init {
       fetchAllGames()
    }

    fun getAllGamesBoardFromDB(): LiveData<List<BoardGameLocal>> {
        return repository.getAllBoardFromDB()
    }

    private fun fetchAllGames() = viewModelScope.launch {
        repository.fetchAllBoardGames()
    }



}