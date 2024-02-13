package sam.sultan.onlineCatalog.catalog.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sam.sultan.onlineCatalog.R
import sam.sultan.onlineCatalog.catalog.model.ProductInfo
import sam.sultan.onlineCatalog.databinding.ProductItemBinding

class ProductRvAdapter: RecyclerView.Adapter<ProductRvAdapter.ViewHolder>() {

    private var productList: ArrayList<ProductInfo> = arrayListOf()

    var clickToDetails:((ProductInfo) -> Unit)? = null
    var clickToSave: ((ProductInfo) -> Unit)? = null

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ProductItemBinding.bind(itemView)
        fun bind(productInfo: ProductInfo){
            binding.priceTxt.paintFlags = binding.priceTxt.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            Glide.with(binding.itemImg).load(R.drawable.shampoo).into(binding.itemImg)
            binding.titleTxt.text = productInfo.title
            binding.subtitleTxt.text = productInfo.subtitle
            binding.rateTxt.text = productInfo.feedback.rating.toString()
            binding.rateAmountTxt.text = productInfo.feedback.count.toString()
            binding.priceTxt.text = productInfo.price.price
            binding.priceWithDiscountTxt.text = productInfo.price.priceWithDiscount
            binding.discount.text = "- "+productInfo.price.discount.toString() + "%"
            binding.itemImg.setOnClickListener { clickToDetails?.invoke(productInfo) }
            if(productInfo.isSaved == true){
                binding.addToFavoriteBtn.setImageResource(R.drawable.saved_icon)
            }else{
                binding.addToFavoriteBtn.setImageResource(R.drawable.add_to_favorite_icon)
            }
            binding.addToFavoriteBtn.setOnClickListener {
                binding.addToFavoriteBtn.setImageResource(R.drawable.saved_icon)
                if(productInfo.isSaved == false){
                    clickToSave?.invoke(productInfo)
                    productInfo.isSaved == true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductRvAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductRvAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setItemList(newList: ArrayList<ProductInfo>){
        productList = newList
        notifyItemChanged(itemCount)
    }

}