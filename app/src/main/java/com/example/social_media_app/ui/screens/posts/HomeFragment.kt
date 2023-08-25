package com.example.social_media_app.ui.screens.posts

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.social_media_app.R
import com.example.social_media_app.data.network.ResponseResult
import com.example.social_media_app.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrievePostsList()
    }

    private fun retrievePostsList() {
        viewModel.retrievePosts()
        binding.loading.visibility = View.VISIBLE
        viewModel.postsListResponse.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseResult.Success -> {
                    val posts = it.data
                    binding.postsRecycler.adapter = PostsAdapter(posts)
                    binding.loading.visibility = View.GONE

                }
                is ResponseResult.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        "There is an error happen " + it.error,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    binding.loading.visibility = View.GONE
                }

                else -> {

                }
            }
        }

    }
}