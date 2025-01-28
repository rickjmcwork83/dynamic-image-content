package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.data.Repository

@Composable
fun DynamicContentScreen() {
    var imageUrl by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    // Fetch the dynamic content (using mocked data now)
    LaunchedEffect(Unit) {
        val content = Repository.getDynamicContent()
        imageUrl = content?.imageUrl.orEmpty()
        text = content?.text.orEmpty()
        isLoading = false
    }

    // Display content
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (imageUrl.isNotEmpty()) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                BasicText(text = text)
            }
        }
    }
}

// Mock data for Preview
@Preview(showBackground = true)
@Composable
fun PreviewDynamicContentScreen() {
    // Use a real public image URL for testing
    val mockImageUrl = "https://haieng.com/wp-content/uploads/2017/10/test-image-500x500.jpg"
    val mockText = "This is a sample text for preview."

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberAsyncImagePainter(mockImageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            BasicText(text = mockText)
        }
    }
}
