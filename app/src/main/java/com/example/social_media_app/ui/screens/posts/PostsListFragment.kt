package com.example.social_media_app.ui.screens.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.social_media_app.R
import com.example.social_media_app.databinding.FragmentPostsListBinding

class PostsListFragment : Fragment() {
    private lateinit var binding: FragmentPostsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_posts_list, container, false)
        return binding.root
    }
}