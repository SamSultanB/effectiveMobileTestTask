package sam.sultan.onlineCatalog.registration

import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
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
        binding.surnameEditTxtContainer.setEndIconDrawable(customClearIcon)
        binding.phoneNumberEditTxtContainer.setEndIconDrawable(customClearIcon)

        registrationResponse()

        binding.nameEditTxt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (viewModel.fieldValidation(s.toString()) == false){
                    binding.nameEditTxt.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.error_red)))
                }else{
                    binding.nameEditTxt.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                }
            }
        })

        binding.surnameEditTxt.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (viewModel.fieldValidation(s.toString()) == false){
                    binding.surnameEditTxt.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.error_red)))
                }else{
                    binding.surnameEditTxt.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                }
            }
        })

        binding.phoneNumberEditTxt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // Call activateBtn when phoneNumberEditTxt is filled
                if (s?.length == binding.phoneNumberEditTxt.maskString.toString().length) {
                    activateBtn()
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun registrationResponse(){
        viewModel.registrationResponse.observe(viewLifecycleOwner, Observer{
            if(it.equals("Saved")){
                findNavController().navigate(R.id.action_registrationFragment_to_profileFragment2)
                val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                bottomNavigationView?.visibility = View.VISIBLE
                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
            }else{
                findNavController().navigate(R.id.action_registrationFragment_to_catalogFragment2)
                val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                bottomNavigationView?.visibility = View.VISIBLE
                Toast.makeText(requireContext(), "User exists", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun activateBtn(){
        val name = binding.nameEditTxt.text.toString()
        val surname = binding.surnameEditTxt.text.toString()
        val number = binding.phoneNumberEditTxt.text.toString()
        val mask = binding.phoneNumberEditTxt.maskString.toString()
        if(viewModel.fieldValidation(name) && viewModel.fieldValidation(surname)){
            binding.loginBtn.isClickable = true
            binding.loginBtn.alpha = 1f
            binding.loginBtn.setOnClickListener {
                val user = UserInfo(name, surname, number)
                viewModel.saveUser(user)
            }
        }
    }

}