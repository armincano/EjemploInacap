package cl.armin20.ejemploinacap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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
           intentExample()
        }
    }

    private fun intentExample() {
        val destination = arrayOf("123@123.cl")
        val subject = "Hola que hace!!"
        val body = getString(R.string.app_name)
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, destination)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}