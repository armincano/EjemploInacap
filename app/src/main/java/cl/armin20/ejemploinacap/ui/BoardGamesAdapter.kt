package cl.armin20.ejemploinacap.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal
import cl.armin20.ejemploinacap.databinding.BoardGamesItemBinding
import com.squareup.picasso.Picasso

class BoardGamesAdapter : RecyclerView.Adapter<BoardGamesAdapter.BoardGameViewHolder>() {

    private var listBoard = listOf<BoardGameLocal>()
    private val selectItem = MutableLiveData<BoardGameLocal>()

    fun updateBoardGames(list: List<BoardGameLocal>) {
        Log.d("CRISS", " ADAPTER $list")
        listBoard = list
        notifyDataSetChanged()
    }

    fun selectItem(): LiveData<BoardGameLocal> {
        return selectItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardGameViewHolder {
        return BoardGameViewHolder(BoardGamesItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BoardGameViewHolder, position: Int) {
        holder.bind(listBoard[position])
    }

    override fun getItemCount(): Int = listBoard.size

    inner class BoardGameViewHolder(
        private val binding: BoardGamesItemBinding
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(item: BoardGameLocal) {
            binding.name.text = item.name
            binding.price.text = item.price
            Picasso.get().load(item.image).into(binding.image)
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
          selectItem.value = listBoard[adapterPosition]
        }
    }
}