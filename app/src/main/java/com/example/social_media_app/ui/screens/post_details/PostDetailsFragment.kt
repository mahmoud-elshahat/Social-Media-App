package com.example.social_media_app.ui.screens.post_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.social_media_app.R
import com.example.social_media_app.data.network.ResponseResult
import com.example.social_media_app.databinding.FragmentPostDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPostDetailsBinding
    private val viewModel: PostDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.fragment_post_details,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCurrentPostFromArgs()

    }

    private fun getCurrentPostFromArgs() {
        val args: PostDetailsFragmentArgs by navArgs()
        binding.post = args.post
        retrievePostComments(args.post.id)
    }

    private fun retrievePostComments(id: Int) {
        viewModel.retrieveComments(id.toString())

        viewModel.postsCommentsResponse.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseResult.Success -> {
                    val comments = it.data
                    if (comments.isEmpty())
                        binding.postDetailsNoComments.visibility = View.VISIBLE
                    else
                        binding.commentsRecycler.adapter = CommentsAdapter(comments)
                    binding.loading.visibility = View.GONE
                }

                is ResponseResult.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        "There is an error happen " + it.error,
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.loading.visibility = View.GONE
                }

                else -> {}
            }
        }
    }
}