package com.example.blog.adapter

import android.content.Context
import android.content.Intent
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


class BlogAdapter(private val context: Context, private val blogs: List<Blog>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.blog_item, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        var currentBlog = blogs[position]
        holder.titleText.text =context.resources.getString(currentBlog.title)
        holder.imgView.setImageResource(currentBlog.image)

        holder.cardView.setOnClickListener {
            val action = BlogListDirections.actionBlogListToBlogDetailFragement2(title = context.resources.getString(currentBlog.title),content = context.resources.getString(currentBlog.content),img = currentBlog.image)
            holder.cardView.findNavController().navigate(action)

//            val intent = Intent(context, BlogDetail::class.java)
//            intent.putExtra("title", context.resources.getString(currentBlog.title))
//            intent.putExtra("content", context.resources.getString(currentBlog.content))
//            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return blogs.size
    }


//    fun addBlog(blog: Blog){
////        blogs.add(blog)
//        notifyItemChanged(blogs.size-1)
//    }

    class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleText : TextView = itemView.findViewById(R.id.item_title)
        val imgView : ImageView = itemView.findViewById(R.id.item_image)
        val cardView :  MaterialCardView = itemView.findViewById(R.id.card_view)
    }
}