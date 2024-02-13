package sam.sultan.onlineCatalog.detailInfo.presentation

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import sam.sultan.onlineCatalog.R
import sam.sultan.onlineCatalog.catalog.model.ProductInfo
import sam.sultan.onlineCatalog.databinding.FragmentDetailInfoBinding
import sam.sultan.onlineCatalog.detailInfo.adapter.ProductInfoRvAdapter

class DetailInfoFragment : Fragment() {

    private var _binding: FragmentDetailInfoBinding? = null
    private val binding: FragmentDetailInfoBinding get() = _binding!!

    private val adapter = ProductInfoRvAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.priceTxt.paintFlags = binding.priceTxt.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        binding.priceTxt2.paintFlags = binding.priceTxt2.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        val product = arguments?.getParcelable<ProductInfo>( "key")
        Glide.with(binding.itemImg).load(R.drawable.shampoo).into(binding.itemImg)

        product?.info?.let { adapter.setInfoList(it) }
        binding.characteristicsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.characteristicsRv.adapter = adapter

        binding.discount.text = "-"+product?.price?.discount.toString()+"%"
        binding.priceTxt.text = product?.price?.price
        binding.priceWithDiscountTxt.text = product?.price?.priceWithDiscount

        binding.titleNameTxt.text = product?.title
        binding.subTitleTxt.text = product?.subtitle
        binding.titleTxt.text = product?.title

        binding.availableTxt.append(product?.available?.toString() + "штук")

        if(product?.feedback?.count!! < 5){
            binding.feedBackTxt.text = product?.feedback.count.toString() + " отзыва"
        }else{
            binding.feedBackTxt.text = product.feedback.count.toString() + " отзывов"
        }
        binding.rateTxt.text = product.feedback.rating.toString()

        binding.hideTxtBtn.setOnClickListener {
            if (binding.brandTxt.visibility == View.GONE && binding.descriptionTxt.visibility == View.GONE){
                binding.brandTxt.visibility = View.VISIBLE
                binding.descriptionTxt.visibility = View.VISIBLE
                binding.hideTxtBtn.text = "Cкрыть"
            }else{
                binding.brandTxt.visibility = View.GONE
                binding.descriptionTxt.visibility = View.GONE
                binding.hideTxtBtn.text = "Подробнее"
            }
        }

        binding.hideConsistanceBtn.setOnClickListener {
            if (binding.consistanceTxt.maxLines == 2){
                binding.consistanceTxt.maxLines = 20
                binding.hideConsistanceBtn.text = "Cкрыть"
            }else{
                binding.consistanceTxt.maxLines = 2
                binding.hideConsistanceBtn.text = "Подробнее"
            }
        }

        binding.priceTxt2.text = product.price.price
        binding.priceWithDiscountTxt2.text = product.price.priceWithDiscount




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}