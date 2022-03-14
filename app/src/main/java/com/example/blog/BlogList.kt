package com.example.blog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.blog.adapter.BlogAdapter
import com.example.blog.data.Datasource
import com.example.blog.databinding.BlogListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.blog.adapter.PopularBlogAdapter
import androidx.recyclerview.widget.LinearLayoutManager





class BlogList : Fragment() {
    private var _binding: BlogListBinding? = null
    private val binding get() = _binding!!

    private lateinit var blogRecyclerView: RecyclerView
    private lateinit var popularRecyclerView: RecyclerView

    private lateinit var createFloatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BlogListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dataSet = Datasource().loadAffirations()
        val linearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        blogRecyclerView = binding.recycleView
        blogRecyclerView.adapter = context?.let { BlogAdapter(it,dataSet) }
        blogRecyclerView.setHasFixedSize(true)


        popularRecyclerView = binding.popularBloogRecyclerView
        popularRecyclerView.adapter = context?.let { PopularBlogAdapter(it,dataSet) }
        popularRecyclerView.setLayoutManager(linearLayoutManager)
        popularRecyclerView.setHasFixedSize(true)


        createFloatingActionButton = binding.addBtn
        createFloatingActionButton.setOnClickListener{
            // action_blogList_to_createBlog
            val action = BlogListDirections.actionBlogListToCreateBlog()
            createFloatingActionButton.findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}