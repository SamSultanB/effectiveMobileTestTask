package sam.sultan.onlineCatalog.catalog.presentation

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
import sam.sultan.onlineCatalog.catalog.adapter.ProductRvAdapter
import sam.sultan.onlineCatalog.databinding.FragmentCatalogBinding


class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding: FragmentCatalogBinding get() = _binding!!

    private val adapter = ProductRvAdapter()

    private val viewModel by viewModel<CatalogViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCatalogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.itemsRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.itemsRv.adapter = adapter
        viewModel.getProducts()
        getProductsResponse()
        adapter.clickToDetails = {
            val bundle = Bundle()
            bundle.putParcelable("key", it)
            findNavController().navigate(R.id.action_catalogFragment2_to_detailInfoFragment, bundle)
        }
        adapter.clickToSave = {
            viewModel.save(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getProductsResponse(){
        viewModel.catalogItemsResponse.observe(viewLifecycleOwner, Observer {
            adapter.setItemList(ArrayList(it))
        })
    }


}