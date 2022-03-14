package com.example.blog.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.blog.BlogListDirections
import com.example.blog.R
import com.example.blog.model.Blog
import com.google.android.material.card.MaterialCardView
import org.w3c.dom.Text

class PopularBlogAdapter(private val context: Context, private val popularBlog: List<Blog>):RecyclerView.Adapter<PopularBlogAdapter.PopularBlogViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularBlogViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.popular_blog_item,parent,false)
        return PopularBlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularBlogViewHolder, position: Int) {
        val currentPopularBlog = popularBlog[position]

        holder.textView.text = context.resources.getString(currentPopularBlog.title)
        holder.imgView.setImageResource(currentPopularBlog.image)

        holder.cardView.setOnClickListener {
            val action = BlogListDirections.actionBlogListToBlogDetailFragement2(
                title = context.resources.getString(currentPopularBlog.title),
                content = context.resources.getString(currentPopularBlog.content),
                img = currentPopularBlog.image
            )
            holder.cardView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return popularBlog.size
    }


    class PopularBlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardView : MaterialCardView = itemView.findViewById(R.id.popularCard)
        val imgView: ImageView = itemView.findViewById(R.id.popularImg)
        val textView : TextView = itemView.findViewById(R.id.popularText)


    }
}
