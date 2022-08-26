package cl.armin20.ejemploinacap.viewmodel

import android.util.Log
import androidx.lifecycle.*
import cl.armin20.ejemploinacap.data.BoardGameRepository
import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal
import kotlinx.coroutines.launch

class BoardGamesViewModel(private val repository: BoardGameRepository): ViewModel() {

    private val _selectedItem = MutableLiveData<BoardGameLocal>()
    val selectedItem: LiveData<BoardGameLocal>
    get() = _selectedItem

    init {
       fetchAllGames()
    }

    fun getAllGamesBoardFromDB(): LiveData<List<BoardGameLocal>> {
        return repository.getAllBoardFromDB()
    }

    fun getSelectItem(item: BoardGameLocal) {
       _selectedItem.value = item
    }

    private fun fetchAllGames() = viewModelScope.launch {
        repository.fetchAllBoardGames()
    }
}