package com.example.social_media_app.ui.screens.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.social_media_app.R
import com.example.social_media_app.databinding.ItemPostBinding
import com.example.social_media_app.domain.model.Post

class PostsAdapter(private val posts: List<Post>, private val navController: NavController) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemPostBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_post, parent, false)
        return PostViewHolder(binding, navController)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    class PostViewHolder(
        private val binding: ItemPostBinding,
        private val navController: NavController
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.itemPostTitle.text = post.title
            binding.itemPostUserName.text = post.userId.toString()
            binding.itemPostContent.text = post.body

            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionFromHomeToDetails(post)
                navController.navigate(action)
            }

        }
    }
}