package cl.armin20.ejemploinacap

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.armin20.ejemploinacap.databinding.FragmentSecondBinding
import cl.armin20.ejemploinacap.viewmodel.BoardGamesViewModel
import cl.armin20.ejemploinacap.viewmodel.BoardViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val boardGamesViewModel: BoardGamesViewModel by activityViewModels {
        BoardViewModelFactory((activity?.application as AppBoardGame).repository)
    }

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        boardGamesViewModel.selectedItem.observe(viewLifecycleOwner) {
            Log.d("CRIS", "DATA SECOND FRAGMENT $it")
        }


        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}