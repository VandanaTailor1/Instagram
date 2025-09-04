package com.livedatasexample.model

data class MemeResponse(
    val count: Int,
    val memes: List<Meme>
)

data class Meme(
    val author: String,
    val nsfw: Boolean,
    val postLink: String,
    val preview: List<String>,
    val spoiler: Boolean,
    val subreddit: String,
    val title: String,
    val ups: Int,
    val url: String
)

data class PhotosResponse(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

data class DogsResponse(
    val message: String,
    val status: String
)