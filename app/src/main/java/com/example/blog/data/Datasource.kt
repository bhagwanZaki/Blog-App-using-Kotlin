package com.example.blog.data

import com.example.blog.R
import com.example.blog.model.Blog

class Datasource {
    fun loadAffirations(): List<Blog> {
        return listOf(
            Blog(R.string.title1,R.string.desc,R.drawable.scenary),
            Blog(R.string.title1,R.string.desc,R.drawable.scenary),
            Blog(R.string.title1,R.string.desc,R.drawable.scenary),
            Blog(R.string.title1,R.string.desc,R.drawable.scenary),
            Blog(R.string.title1,R.string.desc,R.drawable.scenary),
            Blog(R.string.title1,R.string.desc,R.drawable.scenary),
        )
    }

}