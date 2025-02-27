package com.example.newsapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.repository.PostRepository
import com.example.newsapplication.retrofit.Post
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    var posts by mutableStateOf<List<Post>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val fetchedPosts = repository.getPosts()

            // Updating the State
            // any update to 'posts' will trigger
            // a recomposition of any Composable
            // that read this state
            posts = fetchedPosts
        }
    }
}