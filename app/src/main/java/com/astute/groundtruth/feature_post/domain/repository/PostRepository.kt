package com.astute.groundtruth.feature_post.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.astute.groundtruth.core.domain.models.Comment
import com.astute.groundtruth.core.domain.models.Post
import com.astute.groundtruth.core.util.Constants
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.core.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    val posts: Flow<PagingData<Post>>

    suspend fun createPost(description: String, imageUri: Uri): SimpleResource

    suspend fun getPostDetails(postId: String): Resource<Post>

    suspend fun getCommentsForPost(postId: String): Resource<List<Comment>>
}