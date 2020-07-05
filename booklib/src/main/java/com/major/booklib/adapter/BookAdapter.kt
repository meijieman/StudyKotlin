package com.major.booklib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.major.booklib.R
import com.major.booklib.bean.Book

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/4 上午7:19
 */
class BookAdapter(var items: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvBookName.text = item.bookName
        holder.tvAuthor.text = item.author
        holder.itemView.setOnClickListener {
            println("click $item")
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // FIXME: 2020/7/6 此处如何不需要 fbi
        val tvBookName: TextView = itemView.findViewById(R.id.book_name)
        val tvAuthor: TextView = itemView.findViewById(R.id.author)
    }
}