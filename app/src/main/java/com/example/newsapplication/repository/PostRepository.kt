package com.example.newsapplication.repository

import com.example.newsapplication.retrofit.Post
import com.example.newsapplication.retrofit.RetrofitInstance

class PostRepository {
    private val apiService = RetrofitInstance.api

    suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }
}