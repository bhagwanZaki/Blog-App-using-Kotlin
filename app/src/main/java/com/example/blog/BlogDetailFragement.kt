package com.example.blog

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.blog.databinding.FragmentBlogDetailFragementBinding
import kotlin.properties.Delegates


class BlogDetailFragement : Fragment() {
    private var _binding : FragmentBlogDetailFragementBinding? = null
    private val binding get() = _binding!!

    private lateinit var titleTextView: TextView
    private lateinit var contentTextView: TextView
    private lateinit var imageView: ImageView

    private lateinit var titleData: String
    private lateinit var contentData: String
    private var imageData by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlogDetailFragementBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        titleTextView = binding.blogDetailTitle
        contentTextView = binding.blogDetailContent
        imageView = binding.blogDetailImg

        arguments?.let {
            titleData = it.getString("title").toString()
            contentData = it.getString("content").toString()
            imageData = it.getInt("img")
        }

        titleTextView.text = titleData
        contentTextView.text = contentData
        imageView.setImageResource(imageData)
//        titleData = activity?.intent?.extras?.getString("title").toString()
//        contentData = activity?.intent?.extras?.getString("content").toString()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}