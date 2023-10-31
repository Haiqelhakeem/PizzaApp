package lat.pam.pizzaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>, private val clickListener: ItemClickListener) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    data class Item(val imageResId: Int, val title: String, val description: String)
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.menuIcon)
        val title: TextView = itemView.findViewById(R.id.menuTitle)
        val description: TextView = itemView.findViewById(R.id.menuDesc)
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.image.setImageResource(currentItem.imageResId)
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(position)
        }
    }

    override fun getItemCount() = items.size
}
