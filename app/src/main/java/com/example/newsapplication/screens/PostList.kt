package com.example.newsapplication.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newsapplication.retrofit.Post

@Composable
fun PostList(posts: List<Post>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(posts) { post ->
            PostItem(post)
        }
    }
}