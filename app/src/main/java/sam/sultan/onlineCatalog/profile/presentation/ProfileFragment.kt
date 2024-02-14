package sam.sultan.onlineCatalog.profile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import sam.sultan.onlineCatalog.R
import sam.sultan.onlineCatalog.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding get() = _binding!!

    private val viewModel by viewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProfile()
        getProfileResponse()
        binding.favoritesBtn.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment2_to_favoriteFragment)
        }

        binding.quitBtn.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getProfileResponse(){
        viewModel.userProfileResponse.observe(viewLifecycleOwner, Observer{
            binding.nameTxt.text = it.name + " " + it.surname
            binding.phoneNumberTxt.text = it.phoneNumber
        })
    }

}