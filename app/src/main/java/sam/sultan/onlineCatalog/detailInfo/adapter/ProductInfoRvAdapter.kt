package sam.sultan.onlineCatalog.detailInfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sam.sultan.onlineCatalog.R
import sam.sultan.onlineCatalog.catalog.model.Info
import sam.sultan.onlineCatalog.databinding.CharacteristicsItemBinding

class ProductInfoRvAdapter: RecyclerView.Adapter<ProductInfoRvAdapter.ViewHolder>() {

    private var infoList: List<Info> = emptyList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = CharacteristicsItemBinding.bind(itemView)
        fun bind(info: Info){
            binding.titleTxt.text = info.title
            binding.valueTxt.text = info.value
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoRvAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.characteristics_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(infoList[position])
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    fun setInfoList(newList: List<Info>){
        infoList = newList
        notifyItemChanged(itemCount)
    }

}