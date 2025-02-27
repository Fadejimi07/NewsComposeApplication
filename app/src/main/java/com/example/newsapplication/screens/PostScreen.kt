package com.example.newsapplication.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newsapplication.viewmodel.PostViewModel

@Composable
fun PostScreen(viewModel: PostViewModel, modifier: Modifier) {
    val posts = viewModel.posts
    PostList(posts = posts, modifier = modifier)
}