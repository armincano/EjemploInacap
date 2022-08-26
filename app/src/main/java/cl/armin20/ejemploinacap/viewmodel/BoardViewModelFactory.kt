package cl.armin20.ejemploinacap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.armin20.ejemploinacap.data.BoardGameRepository

class BoardViewModelFactory(val repository: BoardGameRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BoardGamesViewModel::class.java)) {
            return BoardGamesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}