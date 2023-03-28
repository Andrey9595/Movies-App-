package ru.anb.testapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.anb.testapi.R
import ru.anb.testapi.models.Categories



class ListAdapter(private var parameters: List<Categories>): RecyclerView.Adapter<ListAdapter. ListViewHolder>() {

    inner class ListViewHolder(view: View): RecyclerView.ViewHolder(view){
        val avatar: ImageView = view.findViewById(R.id.article_image)
        val mainText: TextView = view.findViewById(R.id.textView)
        val text: TextView = view.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:  ListViewHolder, position: Int) {
     val item = parameters[position]
        holder.mainText.text = item.name
        holder.text.text = item.icon
        Glide.with(holder.avatar)
            .load(parameters[position].image)
            .centerCrop()
            .into(holder.avatar)
    }

    override fun getItemCount() = parameters.size

}