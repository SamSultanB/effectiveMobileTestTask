package sam.sultan.onlineCatalog.favorite.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sam.sultan.onlineCatalog.R
import sam.sultan.onlineCatalog.databinding.ProductItemBinding
import sam.sultan.onlineCatalog.favorite.mapper.FavoriteProductInfo

class FavoritesRvAdapter: RecyclerView.Adapter<FavoritesRvAdapter.ViewHolder>(){

    private var favorites: List<FavoriteProductInfo> = emptyList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ProductItemBinding.bind(itemView)
        fun bind(favorite: FavoriteProductInfo){
            binding.priceTxt.paintFlags = binding.priceTxt.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            Glide.with(binding.itemImg).load(R.drawable.shampoo).into(binding.itemImg)
            binding.titleTxt.text = favorite.title
            binding.subtitleTxt.text = favorite.subtitle
            binding.rateTxt.text = favorite.rating.toString()
            binding.rateAmountTxt.text = favorite.count.toString()
            binding.priceTxt.text = favorite.price
            binding.priceWithDiscountTxt.text = favorite.priceWithDiscount
            binding.discount.text = "- "+favorite.discount.toString() + "%"
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoritesRvAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesRvAdapter.ViewHolder, position: Int) {
        holder.bind(favorites[position])
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    fun setFavoritesList(newList: List<FavoriteProductInfo>){
        favorites = newList
        notifyItemChanged(itemCount)
    }
}