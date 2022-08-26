package cl.armin20.ejemploinacap

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.armin20.ejemploinacap.databinding.FragmentFirstBinding
import cl.armin20.ejemploinacap.ui.BoardGamesAdapter
import cl.armin20.ejemploinacap.viewmodel.BoardGamesViewModel
import cl.armin20.ejemploinacap.viewmodel.BoardViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var adapter: BoardGamesAdapter

    private val boardGamesViewModel: BoardGamesViewModel by activityViewModels {
        BoardViewModelFactory((activity?.application as AppBoardGame).repository)
    }

    private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardGamesAdapter()
        setRecyclerView()
        observeData()

    }

    private fun setRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
    }

    private fun observeData() {
        boardGamesViewModel.getAllGamesBoardFromDB().observe(viewLifecycleOwner) {
            Log.d("CRISS", "OBSERVER DATA ${it.size}")
           adapter.updateBoardGames(it)
        }

        adapter.selectItem().observe(viewLifecycleOwner) {
            Log.d("CRISS", "ITEM ${it.name}")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}