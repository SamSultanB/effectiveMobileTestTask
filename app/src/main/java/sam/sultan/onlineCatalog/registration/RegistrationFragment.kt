package sam.sultan.onlineCatalog.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel
import sam.sultan.onlineCatalog.R
import sam.sultan.onlineCatalog.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding: FragmentRegistrationBinding get() = _binding!!

    private val viewModel by viewModel<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val customClearIcon = ContextCompat.getDrawable(requireContext(), R.drawable.cancel_icon)
        binding.nameEditTxtContainer.setEndIconDrawable(customClearIcon)

        binding.loginBtn.setOnClickListener {
            val name = binding.nameEditTxt.text.toString()
            val surname = binding.surnameEditTxt.text.toString()
            val number = binding.nameEditTxt.text.toString()
            findNavController().navigate(R.id.action_registrationFragment_to_catalogFragment2)
            val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            bottomNavigationView?.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}