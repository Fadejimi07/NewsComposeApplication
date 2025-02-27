package com.example.newsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.newsapplication.repository.PostRepository
import com.example.newsapplication.screens.PostScreen
import com.example.newsapplication.ui.theme.NewsApplicationTheme
import com.example.newsapplication.viewmodel.PostViewModel
import com.example.newsapplication.viewmodel.PostViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = PostRepository()
        val viewModelFactory = PostViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        setContent {
            NewsApplicationTheme {
                Scaffold(topBar = { HeaderComposable() }) { innerPadding ->
                    PostScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun HeaderComposable() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "The News App", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "Get the latest news and posts",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

