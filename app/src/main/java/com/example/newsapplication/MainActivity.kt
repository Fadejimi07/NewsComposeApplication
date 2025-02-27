package com.example.newsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.newsapplication.repository.PostRepository
import com.example.newsapplication.screens.PostScreen
import com.example.newsapplication.ui.theme.NewsApplicationTheme
import com.example.newsapplication.viewmodel.PostViewModel
import com.example.newsapplication.viewmodel.PostViewModelFactory

class MainActivity : ComponentActivity() {
    private val repository = PostRepository()
    private val viewModelFactory = PostViewModelFactory(repository)
    private val viewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsApplicationTheme {
                Scaffold { innerPadding ->
                    PostScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

