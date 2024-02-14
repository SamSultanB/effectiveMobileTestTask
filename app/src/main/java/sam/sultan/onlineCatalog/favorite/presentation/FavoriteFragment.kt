package sam.sultan.onlineCatalog.favorite.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import sam.sultan.onlineCatalog.R
import sam.sultan.onlineCatalog.databinding.FragmentFavoriteBinding
import sam.sultan.onlineCatalog.favorite.adapter.FavoritesRvAdapter


class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding: FragmentFavoriteBinding get() = _binding!!
    private val viewModel by viewModel<FavoritesViewModel>()
    private val adapter = FavoritesRvAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowBackBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        viewModel.getFavorites()
        getFavorites()
        binding.favoritesRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.favoritesRv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getFavorites(){
        viewModel.favoritesResponse.observe(viewLifecycleOwner, Observer {
            adapter.setFavoritesList(it)
        })
    }

}