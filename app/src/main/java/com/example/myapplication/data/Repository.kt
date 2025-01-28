package com.example.myapplication.data

object Repository {
    // Mock function to return dynamic content
    suspend fun getDynamicContent(): DynamicContent? {
        // Simulating fetched content (mocked data)
        return DynamicContent(
            imageUrl = "https://haieng.com/wp-content/uploads/2017/10/test-image-500x500.jpg",  // Replace with any valid image URL
            text = "This is a mock text for testing purposes."
        )
    }
}

data class DynamicContent(val imageUrl: String, val text: String)
